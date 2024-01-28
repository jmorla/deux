package org.deuxc.parser;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

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

    private final DeuxTokenizer tokenizer;

    public DeuxScanner(CharBuffer buffer) {
        this(new DeuxTokenizer(null, buffer));
    }

    public DeuxScanner(DeuxTokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public Token getToken() {
        return getToken(0);
    }

    @Override
    public Token getToken(int lookahead) {
        if (lookahead == 0) {
            return token;
        }

        ensureLookahead(lookahead);
        return savedTokens.get(lookahead - 1);
    }

    private void ensureLookahead(int lookahead) {
        for (int i = savedTokens.size(); i < lookahead; i++) {
            savedTokens.add(tokenizer.readToken());
        }
    }

    public void nextToken() {
        prevToken = token;
        if (!savedTokens.isEmpty()) {
            token = savedTokens.remove(0);
        } else {
            token = tokenizer.readToken();
        }
    }

    public Token prevToken() {
        return prevToken;
    }
    
}
