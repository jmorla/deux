package test.org.deuxc.parser;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.deuxc.diagnostic.Log;
import org.deuxc.diagnostic.LoggerFactory;
import org.deuxc.parser.Parser;
import org.deuxc.parser.ParserFactory;
import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.junit.jupiter.api.Test;

public class DeuxParserTest {
    

    @Test
    public void testEOFError() {
        ParserFactory factory = new ParserFactory();
        LoggerFactory loggerFactory = new LoggerFactory();

        String source = "";

        Log l = loggerFactory.getInstance("test.dx", source.toCharArray());
        Parser parser = factory.newParser(l, source.toCharArray());

        CompilationUnit unit = parser.parse();
        
        assertFalse(unit.isValid());
    }
}
