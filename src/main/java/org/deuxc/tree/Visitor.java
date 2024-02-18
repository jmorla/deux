package org.deuxc.tree;

/**
 * An interface for implementing the Visitor pattern in the context of Deux
 * programming language.
 */
public interface Visitor {

    /**
     * Visits a Compilation Unit in the Deux programming language.
     *
     * @param unit The Compilation Unit to be visited.
     */
    void visitCompilationUnit(DeuxTree.CompilationUnit unit);

    /**
     * Visits a Return Statement in the Deux programming language.
     *
     * @param rStmnt The Return Statement to be visited.
     */
    void visitReturnStatement(DeuxTree.ReturnStatement rStmnt);

    /**
     * Visits a Primary Expression in the Deux programming language.
     *
     * @param pExpr The Primary Expression to be visited.
     */
    void visitPrimaryExpression(DeuxTree.PrimaryExpression pExpr);

}
