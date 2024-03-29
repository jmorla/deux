package org.deuxc.parser;

import org.deuxc.diagnostic.Log;

public final class ParserFactory {

    public Parser newParser(Log log, char[] input) {
        DeuxTokenizer tokenizer = new DeuxTokenizer(log, input);
        Lexer lexer = new DeuxScanner(tokenizer);
        return new DeuxParser(lexer, log);        
    }
}
