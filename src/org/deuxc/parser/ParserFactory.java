package org.deuxc.parser;

import java.nio.CharBuffer;

import org.deuxc.diagnostic.Log;

public final class ParserFactory {

    public Parser newParser(Log log, CharBuffer input) {
        DeuxTokenizer tokenizer = new DeuxTokenizer(log, input);
        Lexer lexer = new DeuxScanner(tokenizer);
        return new DeuxParser(lexer, log);        
    }
}
