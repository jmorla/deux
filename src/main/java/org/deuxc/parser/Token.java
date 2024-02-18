
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

    Token(TokenKind kind, int start, int end) {
        this.kind = kind;
        this.start = start;
        this.end = end;
    }

    /**
     * Represents a numeric token, extending the base Token class.
     */
    public static class NumericToken extends Token {

        public final String value;

        NumericToken(String value, int start, int end) {
            super(TokenKind.NUMERIC, start, end);
            this.value = value;
        }
    }

    public String toString() {
        return kind.toString();
    }


    /**
     * This enum defines all types of tokens used by the deux lexer. A token is
     * optionally associated with a name.
     */
    public enum TokenKind {
        ERROR(),
        EOF(),
        RETURN("return"),
        NUMERIC("number"),
        SEMICOLON(";");

        public final String name;

        TokenKind() {
            this(null);
        }

        TokenKind(String name) {
            this.name = name;
        }

        public String toString() {
            switch (this) {
                case ERROR:
                    return "token.bad-symbol";
                case EOF:
                    return "token.end-of-input";
                case NUMERIC:
                    return "token.numeric";
                default:
                    return "token.symbol(" + name + ")";
            }
        }
    }

}