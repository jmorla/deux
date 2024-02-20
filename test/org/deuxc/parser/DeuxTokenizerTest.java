package org.deuxc.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.deuxc.diagnostic.LoggerFactory;
import org.deuxc.parser.Token.TokenKind;

/**
 * DeuxTokenizerTest
 */
public class DeuxTokenizerTest {

    @Test
    public void shouldTokenizeEndOfInputToken() {
        var tokenizer = tokenizerFromSource("");
        var token = tokenizer.readToken();

        assertEquals(token.kind, TokenKind.EOF);
    }

    @Test
    public void shouldTokenizeReturnToken() {
        var tokenizer = tokenizerFromSource("return");
        var token = tokenizer.readToken();

        assertEquals(token.kind, TokenKind.RETURN);
    }


    @Test
    public void shouldTokenizeErrorToken() {
        var tokenizer = tokenizerFromSource("rturn");
        var token = tokenizer.readToken();

        assertEquals(token.kind, TokenKind.ERROR);
    }

    private static DeuxTokenizer tokenizerFromSource(String source) {
        var factory = new LoggerFactory();
        return new DeuxTokenizer(factory.getInstance("test.dx",
        source == null ? null : source.toCharArray()), source.toCharArray());

    }
    
}