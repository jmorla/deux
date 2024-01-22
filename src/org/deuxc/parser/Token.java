
package org.deuxc.parser;

/**
 * This is the class representing a deux token. Each token has several fields
 * that are set by the deux lexer (i.e. start/end position, string value, etc).
 */
public class Token {

    /** The token kind */
    public final TokenKind kind;

    /** The start position of this token */
    public final int start;

    /** The end position of this token */
    public final int end;

    public final String value;

    Token(TokenKind kind, String value, int start, int end) {
        this.kind = kind;
        this.value = value;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Token(" + kind.toString() + ")";
    }


    /**
     * Represents a numeric token, extending the base Token class.
     */
    public static class NumericToken extends Token {

        NumericToken(String value, int start, int end) {
            super(TokenKind.NUMERIC, value, start, end);
        }

        @Override
        public String toString() {
            return "Number(" + value + ")";
        }

    } 

    /**
     * This enum defines all types of tokens used by the deux lexer. A token is
     * optionally associated with a name.
     */
    public enum TokenKind {
        ERROR(),
        EOF(),
        RETURN("return"),
        NUMERIC(),
        SEMICOLON(";");

        public final String name;

        TokenKind() {
            this(null);
        }

        TokenKind(String name) {
            this.name = name;
        }

    }

}