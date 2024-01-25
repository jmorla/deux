package org.deuxc;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.deuxc.parser.DeuxTokenizer;
import org.deuxc.parser.Token;
import org.deuxc.parser.Token.TokenKind;

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
        Reader reader;
        if (args != null && args.length > 0) {
            if (args[0].equals("-f")) {
                reader = new FileReader(args[1]);
            } else {
                reader = new StringReader(args[0]);
            }
        } else {
            reader = new StringReader("");
        }

        DeuxTokenizer deuxTokenizer = new DeuxTokenizer(reader);

        Token token;
        do {
            token = deuxTokenizer.readToken();
            System.out.println(token);
        } while (token.kind != TokenKind.EOF);


    }
}
