package main.java.org.deuxc.parser;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import main.java.org.deuxc.diagnostic.Log;

/**
 * The DeuxScanner class implements the Lexer interface and serves as a
 * tokenizer for the Deux language.
 * It is responsible for scanning and providing tokens from a character buffer.
 */
public class DeuxScanner implements Lexer {

    /**
     * The token, set by nextToken().
     */
    private Token token;

    /**
     * The previous token, set by nextToken().
     */
    private Token prevToken;

    /** Buffer of saved tokens (used during lookahead)
     */
    private final List<Token> savedTokens = new ArrayList<>();

    /**
     * The underlying DeuxTokenizer responsible for tokenizing the input.
     */
    private final DeuxTokenizer tokenizer;

    /**
     * Constructs a DeuxScanner with the specified log and character buffer.
     *
     * @param log    The log to be used for reporting lexer errors and diagnostics.
     * @param buffer The character buffer from which tokens will be scanned.
     */
    public DeuxScanner(Log log, CharBuffer buffer) {
        this(new DeuxTokenizer(log, buffer.array()));
    }

    /**
     * Constructs a DeuxScanner with the specified DeuxTokenizer.
     *
     * @param tokenizer The DeuxTokenizer responsible for tokenizing the input.
     */
    public DeuxScanner(DeuxTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }


    /**
     * Gets the current token.
     *
     * @return The current token.
     */
    @Override
    public Token getToken() {
        return getToken(0);
    }

    /**
     * Gets a token at a specified lookahead position.
     *
     * @param lookahead The number of tokens to look ahead.
     * @return The token at the specified lookahead position.
     */
    @Override
    public Token getToken(int lookahead) {
        if (lookahead == 0) {
            return token;
        }

        ensureLookahead(lookahead);
        return savedTokens.get(lookahead - 1);
    }

    /**
     * Ensures that the specified number of tokens are available in the lookahead
     * buffer.
     *
     * @param lookahead The number of tokens to ensure in the lookahead buffer.
     */
    private void ensureLookahead(int lookahead) {
        for (int i = savedTokens.size(); i < lookahead; i++) {
            savedTokens.add(tokenizer.readToken());
        }
    }

    /**
     * Advances to the next token in the input.
     */
    public void nextToken() {
        prevToken = token;
        if (!savedTokens.isEmpty()) {
            token = savedTokens.remove(0);
        } else {
            token = tokenizer.readToken();
        }
    }

    /**
     * Gets the previous token.
     *
     * @return The previous token.
     */
    public Token prevToken() {
        return prevToken;
    }
    
}
