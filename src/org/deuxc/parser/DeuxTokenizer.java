package org.deuxc.parser;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

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
     * Constructs a DeuxTokenizer with the specified input source.
     *
     * @param source The input source reader for the tokenizer.
     *               It provides the source code to be tokenized.
     */
    protected DeuxTokenizer(Reader source) {
        super(null, source);

        for (TokenKind kind : TokenKind.values()) {
            if (kind.name != null) {
                keywords.put(kind.name, kind);
            }
        }
    }
    
    
}
