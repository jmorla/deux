package org.deuxc.parser;

import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

import org.deuxc.diagnostic.Log;
import org.deuxc.diagnostic.Diagnostic.DiagnosticFragment;
import org.deuxc.diagnostic.Diagnostic.Errors;
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
     * Log for error reporting.
     */
    private final Log log;


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
    public DeuxTokenizer(Log log, CharBuffer buffer) {
        super(buffer.array());
        this.literal = new StringBuilder();
        this.log = log;
        for (TokenKind kind : TokenKind.values()) {
            if (kind.name != null) {
                keywords.put(kind.name, kind);
            }
        }
    }


    /**
     * Reports lexical errors
     * 
    */
    private void lexError(int pos, DiagnosticFragment error) {
        log.error(pos, error);
        kind = TokenKind.ERROR;
    }

    /**
     * Reads and returns the next token from the input source.
     *
     * @return The next token read from the input source.
     */
    public Token readToken() {

        int pos;
        literal.setLength(0);
        loop: while (true) {
            pos = getPosition();

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
                    scanIdent(pos);
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
                    lexError(pos, Errors.illegalSymbolError(String.valueOf(get())));
                    next();
                    break loop;
            }
        }
        
        int endPos = getPosition();

        if (kind == TokenKind.NUMERIC) {
            return new NumericToken(literal.toString(), pos, endPos);
        }

        return new Token(kind, pos, endPos);
    }
    

    /**
     * Scans and processes an identifier.
     * performs the necessary operations to process the identifier found
     * during scanning.
     */
    private void scanIdent(int pos) {
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
                    checkIdentifier(pos);
                    return;
            }
            next();
        } while (true);
    }

    /**
     * Checks if identifier is a keyword of valid name.
     */
    private void checkIdentifier(int pos) {
        String ident = literal.toString();
        if (keywords.containsKey(ident)) {
            kind = keywords.get(ident);
        } else {
            lexError(pos, Errors.illegalSymbolError(ident));
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
