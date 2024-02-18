package main.java.org.deuxc.parser;

import main.java.org.deuxc.tree.DeuxTree.CompilationUnit;

/**
 * The {@code Parser} interface in the Deux Programming language
 * generate the AST for the Deux Programming language spec
 */
public interface Parser {
    

    /**
     * Parses the source code and generates the corresponding Compilation Unit.
     *
     * @return The Compilation Unit representing the Abstract Syntax Tree (AST).
     */
    CompilationUnit parse();
}
