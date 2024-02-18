package org.deuxc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.deuxc.compiler.CompilerFactory;
import org.deuxc.compiler.DeuxCompiler;

/**
 * The entry point for the Deuxc compiler.
 * This class contains the main method to start the compilation process.
 * It serves as the central component for initiating the compilation of Deuxc
 * source code.
 * 
 * @author Jorge Morla
 */
public class Main {
    
    /**
     * The main method to start the Deuxc compilation process.
     * 
     * @param args Command-line arguments (if any) passed to the compiler.
     */
    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            System.err.println("deuxc: fatal error: no input files");
            System.err.println("compilation terminated.");
            System.exit(64);
        }  

        if (!Files.exists(Path.of(args[0]))) {
            System.err.printf("File %s does not exists\n", args[0]);
            System.exit(64);
        }

        DeuxCompiler compiler = CompilerFactory.newCompiler();
        
        compiler.compile(Path.of(args[0]));
    }

}
