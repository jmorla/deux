package org.deuxc.parser;


/**
 * The Lexical Analizer interface designed to map an input stream of characters
 * into a deux token sequence
*/
public interface Lexer {

    /**
     * Retrieves the next token from the input source.
     *
     *  @return The next token from the input source.
     */
    Token getToken();


    /**
     * Retrieves a token from the input source with a specified lookahead.
     *
     * @param lookahead The number of tokens to lookahead
     * @return The token at the current position with the specified lookahead.
     */
    Token getToken(int lookahead);
    
}
