package org.deuxc.tree;

import org.deuxc.tree.DeuxTree.BinaryExpression;
import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.deuxc.tree.DeuxTree.ParseNode;
import org.deuxc.tree.DeuxTree.PrimaryExpression;
import org.deuxc.tree.DeuxTree.ReturnStatement;

/**
 * The AbstractVisitor class implements the Visitor interface and serves as a
 * base class for
 * visitors operating on various elements of a compilation unit.
 *
 * <p>
 * This class provides default implementations for visiting a CompilationUnit,
 * ReturnStatement,
 * and PrimaryExpression. Each method delegates the acceptance of the
 * corresponding element to
 * the accept method of that element, thereby facilitating the traversal of the
 * abstract syntax tree.
 * </p>
 *
 * <p>
 * It is essential for subclasses to override these methods according to their
 * specific requirements.
 * </p>
 *
 * @version 1.0
 */
public abstract class AbstractVisitor implements Visitor {

    /**
     * Visits a CompilationUnit, initiating the traversal of its elements.
     *
     * @param unit The CompilationUnit to be visited.
     */
    @Override
    public void visitCompilationUnit(CompilationUnit unit) {
        this.visit(unit);
    }

    /**
     * Visits a ReturnStatement, initiating the traversal of its elements.
     *
     * @param rStmnt The ReturnStatement to be visited.
     */
    @Override
    public void visitReturnStatement(ReturnStatement rStmnt) {
        this.visit(rStmnt);
    }

    /**
     * Visits a PrimaryExpression, initiating the traversal of its elements.
     *
     * @param pExpr The PrimaryExpression to be visited.
     */
    @Override
    public void visitPrimaryExpression(PrimaryExpression pExpr) {
        this.visit(pExpr);
    }

    /**
     * Visits a BinaryExpression, initiating the traversal of its elements.
     *
     * @param pExpr The BinaryExpression to be visited.
     */
    public void visitBinaryExpression(BinaryExpression bExpr) {
        this.visit(bExpr);
    }

    private void visit(ParseNode node) {
        throw new AssertionError();
    }
    
}
