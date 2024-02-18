package main.java.org.deuxc.compiler;

import main.java.org.deuxc.diagnostic.LoggerFactory;
import main.java.org.deuxc.parser.ParserFactory;

public class CompilerFactory {

    public static DeuxCompiler newCompiler() {

        return new DeuxCompiler(
                new LoggerFactory(),
                new ParserFactory(),
                new Enter(),
                new Generator());
    }
}
