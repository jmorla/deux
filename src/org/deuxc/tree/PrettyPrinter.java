package org.deuxc.tree;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import org.deuxc.diagnostic.LoggerFactory;
import org.deuxc.parser.Parser;
import org.deuxc.parser.ParserFactory;
import org.deuxc.tree.DeuxTree.BinaryExpression;
import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.deuxc.tree.DeuxTree.Expression;
import org.deuxc.tree.DeuxTree.ParseNode;
import org.deuxc.tree.DeuxTree.PrimaryExpression;
import org.deuxc.tree.DeuxTree.ReturnStatement;
import org.deuxc.tree.DeuxTree.Statement;

/**
 * The PrettyPrinter class is responsible for printing the abstract syntax tree
 * (AST)
 * in a visually organized and readable format.
 * <p>
 * This class extends the AbstractVisitor class and implements the functionality
 * to traverse the AST and print its nodes.
 * </p>
 * <p>
 * Example usage:
 * 
 * <pre>{@code
 * PrettyPrinter printer = new PrettyPrinter();
 * printer.print(rootNode); // rootNode is the root of the AST to be printed
 * }</pre>
 * </p>
 * <p>
 * Note: This class assumes that the AST nodes are properly structured and
 * implements
 * the necessary methods for traversal.
 * </p>
 * 
 * @author Jorge L. Morla
 * @version 0.1-beta
 */
public class PrettyPrinter extends AbstractVisitor {

    private final int identSize;
    private final Writer out;

    /**
     * Constructs a new PrettyPrinter object.
     * 
     * @param writer Where we write the result
     */
    public PrettyPrinter(PrintWriter writer) {
        this.identSize = 4;
        this.out = writer;
    }

    /**
     * Constructs a new PrettyPrinter object that prints tree in stdout.
     */
    public PrettyPrinter() {
        this(new PrintWriter(System.out));
    }

    /**
     * Prints the provided CompilationUnit by traversing its abstract syntax tree.
     * 
     * @param unit the CompilationUnit to be printed
     */
    public void print(CompilationUnit unit) {
        if (unit == null) {
            return;
        }
        unit.accept(this);
        flush();
    }
    
    private void printNode(ParseNode node) {
        println(node.getClass().getSimpleName());
    }
    
    private void printIdent(int level) {
        print(" ".repeat(level * identSize));
    }

    private void println(String str) {
        print(str + '\n');
    }

    private void print(String str) {
        try {
            out.append(str);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void flush() {
        try {
            out.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void visitCompilationUnit(CompilationUnit unit) {
        printNode(unit);
        Statement statement = unit.getStmnt();
        if (statement != null) {
            printIdent(1);
            statement.accept(this);   
        }
    }

    @Override
    public void visitReturnStatement(ReturnStatement rStmnt) {
        printNode(rStmnt);
        Expression expr = rStmnt.getExpr();
        if (expr != null) {
            printIdent(2);
            expr.accept(this);
        }
    }

    @Override
    public void visitPrimaryExpression(PrimaryExpression pExpr) {
        printNode(pExpr);
        printIdent(3);
        print("LiteralValue(" + pExpr.getValue() + ")");
        println("");
    }

    

    @Override
    public void visitBinaryExpression(BinaryExpression bExpr) {
        printNode(bExpr);
        printIdent(3);
        println("LiteralValue(" + bExpr.getLeftValue() + ")");
        printIdent(3);
        println("InfixOperator(" + bExpr.getOperator().name + ")");
        printIdent(3);
        println("LiteralValue(" + bExpr.getRightValue() + ")");
    }

    public static void main(String[] args) {
        PrettyPrinter printer = new PrettyPrinter();

        char[] source = "return 10 + 10;".toCharArray();


        Parser parser = new ParserFactory().newParser(
                new LoggerFactory().getInstance("dummy.dx", source), source);
            
        printer.print(parser.parse());

    }

}