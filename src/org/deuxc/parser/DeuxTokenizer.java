package org.deuxc.parser;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.deuxc.parser.Token.NumericToken;
import org.deuxc.parser.Token.TokenKind;

/**
 * The DeuxTokenizer class designed to map an input stream of characters
 * into a deux token sequence
 */
public class DeuxTokenizer extends BaseReader {

    /**
     * Keyword array. Maps name indices to Token.
     */
    private final Map<String, TokenKind> keywords = new HashMap<>();

    /**
     * Buffer for building literals
     */
    private final StringBuilder literal;


    /**
     * The token kind, set by nextToken().
     */
    private TokenKind kind;

    /**
     * Constructs a DeuxTokenizer with the specified input source.
     *
     * @param source The input source reader for the tokenizer.
     *               It provides the source code to be tokenized.
     */
    public DeuxTokenizer(Reader source) {
        super(null, source);
        this.literal = new StringBuilder();
        for (TokenKind kind : TokenKind.values()) {
            if (kind.name != null) {
                keywords.put(kind.name, kind);
            }
        }
    }

    /**
     * Reads and returns the next token from the input source.
     *
     * @return The next token read from the input source.
     */
    public Token readToken() {

        literal.setLength(0);
        loop: while (true) {

            switch (get()) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    next();
                    break;
                case '0': case '1': case '2':
                case '3': case '4': case '5':
                case '6': case '7': case '8':
                case '9':
                    scanNumber();
                    break loop;
                default:
                    if (getCodePoint() == -1) {
                        kind = TokenKind.EOF;
                        break loop;
                    }
                    next();
            }
        }

        if (kind == TokenKind.NUMERIC) {
            return new NumericToken(literal.toString(), 0, 0);
        }

        if (kind == TokenKind.EOF) {
            return new Token(kind, null, 0, 0);
        }

        return new Token(TokenKind.ERROR, null, 0, 0);
    }

    /**
     * Scans numeric characters until a non-digit character is encountered.
     */
    private void scanNumber() {
        do {
            put();
            next();
        } while (isDigit());

        kind = TokenKind.NUMERIC;
    }

    /**
     * check if current char is a digit
    */
    private boolean isDigit() {
        char c = get();
        return c >= '0' && c <= '9';
    }

    /**
     * Appends current char to literal buffer
    */
    private void put() {
        literal.append(get());
    }
}
