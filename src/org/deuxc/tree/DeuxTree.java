package org.deuxc.tree;

/**
 * Root class for abstract syntax tree nodes. It provides definitions
 * for specific tree nodes as subclasses nested inside.
 */
public class DeuxTree {

    /**
     * Represents a compilation unit in a programming language.
     * A compilation unit typically corresponds to a source file.
     */
    public static final class CompilationUnit implements Visitable {
        private Statement stmnt;

        @Override
        public void accept(Visitor t) {
            t.visitCompilationUnit(this);
        }

        public Statement getStmnt() {
            return stmnt;
        }
    }

    /**
     * Represents a general programming statement.
     * Add fields and methods related to statements here.
     */
    public static abstract sealed class Statement implements Visitable permits ReturnStatement {

    }

    /**
     * Represents a return statement
     */
    public static final class ReturnStatement extends Statement {
        private Expression expr;

        @Override
        public void accept(Visitor t) {
            t.visitReturnStatement(this);
        }

        public Expression getExpr() {
            return expr;
        }
    }

    /**
     * Represents a general expression in a programming language.
     * Add fields and methods related to expressions here.
     */
    public static abstract sealed class Expression implements Visitable {

    }

    /**
     * Represents a primary expression, which is a subtype of Expression.
     * Add any specific fields or methods related to primary expressions here.
     */
    public static final class PrimaryExpression extends Expression {

        @Override
        public void accept(Visitor t) {
            t.visitPrimaryExpression(this);
        }

    }

}
