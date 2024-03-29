package org.deuxc.compiler;

import static org.deuxc.compiler.AsmMemonic.*;

import java.io.IOException;
import java.io.Writer;

import org.deuxc.tree.AbstractVisitor;
import org.deuxc.tree.DeuxTree.BinaryExpression;
import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.deuxc.tree.DeuxTree.PrimaryExpression;
import org.deuxc.tree.DeuxTree.ReturnStatement;

/**
 * Generator is responsible for compiling Deux programming language code into
 * machine code.
 */
public class Generator extends AbstractVisitor {

    private StringBuilder code = new StringBuilder();
    
    public void generate(CompilationUnit unit, SymbolTable symbtab, Writer out) {
        try {
            unit.accept(this);
            out.append(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitCompilationUnit(CompilationUnit unit) {
        emitGlobal(start);
        emitLabel(start);
        ReturnStatement statement = (ReturnStatement) unit.getStmnt();
        statement.accept(this);
        emit(SYSCALL);
    }


    @Override
    public void visitReturnStatement(ReturnStatement rStmnt) {
        var expr = rStmnt.getExpr();
        expr.accept(this);
    }

    @Override
    public void visitBinaryExpression(BinaryExpression bExpr) {
        emitInstruction(MOV, RDI, bExpr.getLeftValue());
        emitInstruction(ADD, RDI, bExpr.getRightValue());
        emitInstruction(MOV, RAX, "60");
    }

    @Override
    public void visitPrimaryExpression(PrimaryExpression pExpr) {
        emitInstruction(MOV, RAX, "60");
        emitInstruction(MOV, RDI, pExpr.getValue());
    }

    private void emit(String... args) {
        for (String arg : args) {
            code.append(arg);
        }
        newLine();
    }

    private void emitInstruction(String operator, String operand1, String operand2) {
        emit(operator, " ", operand1, SEPARATOR, " ", operand2);
    }

    private void emitGlobal(String label) {
        emit(global, " ", label);
    }

    private void emitLabel(String label) {
        emit(label, ":");
    }



    private void newLine() {
        code.append("\n");
    }

}
