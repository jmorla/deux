package org.deuxc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.deuxc.diagnostic.DiagnosticLogger;
import org.deuxc.diagnostic.DiagnosticSource;
import org.deuxc.parser.DeuxParser;
import org.deuxc.parser.DeuxScanner;
import org.deuxc.tree.DeuxTree.CompilationUnit;

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

        Charset charset = Charset.defaultCharset();
        byte[] bytes = Files.readAllBytes(Path.of(args[0]));
        CharBuffer buffer = charset.decode(ByteBuffer.wrap(bytes));

        DiagnosticSource source = new DiagnosticSource(
                Path.of(args[0]).getFileName().toString(), buffer.array());
            
        DiagnosticLogger logger = new DiagnosticLogger(source);

        DeuxScanner scanner = new DeuxScanner(logger, buffer);

        DeuxParser parser = new DeuxParser(scanner, logger);

        CompilationUnit unit = parser.parse();
        System.out.println("Valid: " + unit.isValid());
    }

}
