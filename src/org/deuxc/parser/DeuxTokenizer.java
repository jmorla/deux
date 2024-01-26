package org.deuxc.parser;

import java.nio.CharBuffer;
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
    public DeuxTokenizer(CharBuffer buffer) {
        super(null, buffer.array());
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
                case 'a': case 'A': case 'b': case 'B': case 'c': case 'C':
                case 'd': case 'D': case 'e': case 'E': case 'f': case 'F':
                case 'g': case 'G': case 'h': case 'H': case 'i': case 'I':
                case 'j': case 'J': case 'k': case 'K': case 'l': case 'L':
                case 'm': case 'M': case 'n': case 'N': case 'o': case 'O':
                case 'p': case 'P': case 'q': case 'Q': case 'r': case 'R':
                case 's': case 'S': case 't': case 'T': case 'u': case 'U':
                case 'v': case 'V': case 'w': case 'W': case 'x': case 'X':
                case 'y': case 'Y': case 'z': case 'Z':
                    scanIdent();
                    break loop;
                case ';':
                    kind = TokenKind.SEMICOLON;
                    next();
                    break loop;
                default:
                    if (get() == EOF) {
                        kind = TokenKind.EOF;
                        break loop;
                    }
                    kind = TokenKind.ERROR;
                    next();
                    break loop;
            }
        }

        if (kind == TokenKind.NUMERIC) {
            return new NumericToken(literal.toString(), 0, 0);
        }

        if (kind == TokenKind.EOF) {
            return new Token(kind, null, 0, 0);
        }

        if (kind == TokenKind.SEMICOLON) {
            return new Token(kind, null, 0, 0);
        }

        if (kind == TokenKind.RETURN) {
            return new Token(kind, null, 0, 0);
        }

        return new Token(TokenKind.ERROR, null, 0, 0);
    }

    /**
     * Scans and processes an identifier.
     * performs the necessary operations to process the identifier found
     * during scanning.
     */
    private void scanIdent() {
        put();
        next();

        do {
            switch (get()) {
                case 'a': case 'A': case 'b': case 'B': case 'c': case 'C':
                case 'd': case 'D': case 'e': case 'E': case 'f': case 'F':
                case 'g': case 'G': case 'h': case 'H': case 'i': case 'I':
                case 'j': case 'J': case 'k': case 'K': case 'l': case 'L':
                case 'm': case 'M': case 'n': case 'N': case 'o': case 'O':
                case 'p': case 'P': case 'q': case 'Q': case 'r': case 'R':
                case 's': case 'S': case 't': case 'T': case 'u': case 'U':
                case 'v': case 'V': case 'w': case 'W': case 'x': case 'X':
                case 'y': case 'Y': case 'z': case 'Z':
                    put();
                    break;
                default:
                    checkIdentifier();
                    return;
            }
            next();
        } while (true);
    }

    /**
     * Checks if identifier is a keyword of valid name.
     */
    private void checkIdentifier() {
        String ident = literal.toString();
        if (keywords.containsKey(ident)) {
            kind = keywords.get(ident);
        } else {
            kind = TokenKind.ERROR;
        }
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
        switch (get()) {
            case '0': case '1': case '2':
            case '3': case '4': case '5':
            case '6': case '7': case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    /**
     * Appends current char to literal buffer
    */
    private void put() {
        literal.append(get());
    }
}
