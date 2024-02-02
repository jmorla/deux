package org.deuxc.parser;

import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.deuxc.tree.DeuxTree.Expression;
import org.deuxc.tree.DeuxTree.PrimaryExpression;
import org.deuxc.tree.DeuxTree.ReturnStatement;
import org.deuxc.tree.DeuxTree.Statement;

/**
 * The {@code DeuxParser} class is an implementation of the {@link Parser} interface
 * generate the AST for the Deux Programming language spec
 */
public class DeuxParser implements Parser {

    private Lexer scanner;


    public DeuxParser (Lexer scanner) {
        this.scanner = scanner;
        scanner.nextToken();
    }

    /**
     * Parses the source code and generates the corresponding Compilation Unit.
     * 
     * @return The Compilation Unit representing the Abstract Syntax Tree (AST).
     */
    @Override
    public CompilationUnit parse() {
        return new CompilationUnit();
    }

    private Statement parseStatement() {
        return null;
    }

    private ReturnStatement parseReturnStatement() {
        return null;
    }

    private Expression parseExpression() {
        return null;
    }

    private PrimaryExpression primaryExpression() {
        return null;
    }
    
    private Token peek() {
        return scanner.getToken();
    }
}
