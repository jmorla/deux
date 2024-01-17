package org.deuxc.parser;

/**
 * The DeuxTokenizer class designed to map an input stream of characters
 * into a deux token sequence
 */
public class DeuxTokenizer implements Lexer {

    /**
     * Retrieves the next token from the input source.
     *
     * @return The next token from the input source.
     */
    @Override
    public Token getToken() {
        return null;
    }

    /**
     * Retrieves a token from the input source with a specified lookahead.
     * This method returns the token at the current position in the input source,
     * considering the specified lookahead to predict future tokens.
     *
     * @param lookahead The number of tokens to lookahead for prediction.
     * @return The token at the current position with the specified lookahead.
     */
    @Override
    public Token getToken(int lookahead) {
        return null;
    }
    
    
}
