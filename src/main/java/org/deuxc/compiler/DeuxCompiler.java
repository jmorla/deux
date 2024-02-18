package org.deuxc.compiler;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.deuxc.diagnostic.Log;
import org.deuxc.diagnostic.LoggerFactory;
import org.deuxc.parser.Parser;
import org.deuxc.parser.ParserFactory;
import org.deuxc.tree.DeuxTree.CompilationUnit;

/**
 * The DeuxCompiler class represents a compiler for the Deux programming
 * language. provides functionalities to compile Deux source code into
 * executable machine code or intermediate representation.
 */
public class DeuxCompiler {

    public static final String VERSION = "Deux 0.1.0-alpha";

    private final LoggerFactory loggerFactory;
    private final ParserFactory parserFactory;
    private final Enter enter;
    private final Generator gen;

    public DeuxCompiler(LoggerFactory lfactory, ParserFactory pfactory, Enter enter, Generator gen) {
        this.loggerFactory = lfactory;
        this.parserFactory = pfactory;
        this.enter = enter;
        this.gen = gen;
    }
    
    
    public void compile(Path file) throws IOException {
        
        char[] source = readSource(file);
        Log log = loggerFactory.getInstance(file.getFileName().toString(), source);
        
        Parser parser = parserFactory.newParser(log, source);

        CompilationUnit unit = parser.parse(); // sintax & lexical analysis

        if (!unit.isValid())
            return;
        // enter.complete(unit); // semantic analysis

        StringWriter out = new StringWriter();
        gen.generate(unit, null, out); // generate assembly

        System.out.println(out);
    }
    

    private char[] readSource(Path file) throws IOException {
        byte[] source = Files.readAllBytes(file);
        return new String(source, StandardCharsets.UTF_8).toCharArray();
    }
}
