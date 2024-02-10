package org.deuxc.tools;

import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.deuxc.tree.DeuxTree.PrimaryExpression;
import org.deuxc.tree.DeuxTree.ReturnStatement;
import org.deuxc.tree.Visitor;

/**
 * DeuxCompiler is responsible for compiling Deux programming language code into
 * machine code.
 */
public class Generator implements Visitor {

    @Override
    public void visitCompilationUnit(CompilationUnit unit) {}

    @Override
    public void visitReturnStatement(ReturnStatement rStmnt) {}

    @Override
    public void visitPrimaryExpression(PrimaryExpression pExpr) {}
    
}
