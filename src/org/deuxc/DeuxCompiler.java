package org.deuxc;

import org.deuxc.diagnostic.Log;
import org.deuxc.parser.Parser;

/**
 * The DeuxCompiler class represents a compiler for the Deux programming
 * language. provides functionalities to compile Deux source code into
 * executable machine code or intermediate representation.
 */
public class DeuxCompiler {

    public static final String VERSION = "Deux 0.1.0-alpha";

    public DeuxCompiler(String filename) {
    }
    

    private Log log;
    private Parser parser;
    
}
