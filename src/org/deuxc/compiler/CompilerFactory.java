package org.deuxc.compiler;

import org.deuxc.diagnostic.LoggerFactory;
import org.deuxc.parser.ParserFactory;

public class CompilerFactory {

    public static DeuxCompiler newCompiler() {

        return new DeuxCompiler(
                new LoggerFactory(),
                new ParserFactory(),
                new Enter(),
                new Generator());
    }
}
