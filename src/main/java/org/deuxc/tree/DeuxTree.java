package org.deuxc.tree;

/**
 * Root class for abstract syntax tree nodes. It provides definitions
 * for specific tree nodes as subclasses nested inside.
 */
public class DeuxTree {

    public static abstract class ParseNode {

        private int pos;

        public void setPos(int pos) {
            this.pos = pos;
        }

        public int getPos() {
            return pos;
        }
    }

    /**
     * Represents a compilation unit in a programming language.
     * A compilation unit typically corresponds to a source file.
     */
    public static final class CompilationUnit extends ParseNode implements Visitable {
        private final boolean valid;
        private Statement stmnt;

        public CompilationUnit() {
            this.valid = false;
        }

        public CompilationUnit(Statement statement) {
            this.stmnt = statement;
            this.valid = true;
        }

        @Override
        public void accept(Visitor t) {
            t.visitCompilationUnit(this);
        }

        public Statement getStmnt() {
            return stmnt;
        }

        public boolean isValid() {
            return valid;
        }
    }

    /**
     * Represents a general programming statement.
     * Add fields and methods related to statements here.
     */
    public static abstract sealed class Statement
            extends ParseNode implements Visitable permits ReturnStatement {

    }

    /**
     * Represents a return statement
     */
    public static final class ReturnStatement extends Statement {
        private Expression expr;

        public ReturnStatement(Expression expression) {
            this.expr = expression;
        }

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

        private String value;

        public PrimaryExpression(String value) {
            this.value = value;
        }

        @Override
        public void accept(Visitor t) {
            t.visitPrimaryExpression(this);
        }

        public String getValue() {
            return value;
        }

    }

}
