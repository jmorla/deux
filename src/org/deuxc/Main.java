package org.deuxc;

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
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        for(String arg : args) {
            System.out.print(arg);
            System.out.print(" ");
        }
    }
}
