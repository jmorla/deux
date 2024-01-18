
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
     * This enum defines all types of tokens used by the deux lexer. A token is
     * optionally associated with a name.
     */
    public enum TokenKind {
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