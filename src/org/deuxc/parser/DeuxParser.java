package org.deuxc.parser;

import org.deuxc.diagnostic.Log;
import org.deuxc.diagnostic.Diagnostic.Error;
import org.deuxc.diagnostic.Diagnostic.Errors;
import org.deuxc.parser.Token.TokenKind;
import org.deuxc.tree.DeuxTree.CompilationUnit;
import org.deuxc.tree.DeuxTree.Expression;
import org.deuxc.tree.DeuxTree.PrimaryExpression;
import org.deuxc.tree.DeuxTree.ReturnStatement;

/**
 * The {@code DeuxParser} class is an implementation of the {@link Parser}
 * interface
 * generate the AST for the Deux Programming language spec
 */
public class DeuxParser implements Parser {

    private final Lexer scanner;
    private final Log log;

    public DeuxParser(Lexer scanner, Log log) {
        this.scanner = scanner;
        this.log = log;
        scanner.nextToken(); // initialize scanner
    }

    /**
     * Parses a compilation unit.
     * 
     * @return A CompilationUnit representing the parsed compilation unit.
     */
    @Override
    public CompilationUnit parse() {
        try {
            if (check(TokenKind.EOF)) {
                log.error(Errors.unexpectedEOI());
                return new CompilationUnit();
            }
            var statement = parseReturnStatement();
            expect(TokenKind.EOF, Errors.missingSymbol("eof"));
            return new CompilationUnit(statement);
        } catch (ParseError error) {
            // we must syncronize the parser here
            return new CompilationUnit();
        }
    }

    private ReturnStatement parseReturnStatement() {
        expect(TokenKind.RETURN, Errors.missingReturnStatement());
        Expression expr = parsePrimaryExpression();
        expect(TokenKind.SEMICOLON, Errors.missingSymbol(TokenKind.SEMICOLON.name));
        return new ReturnStatement(expr);
    }

    private PrimaryExpression parsePrimaryExpression() {
        Token.NumericToken token = (Token.NumericToken) 
        expect(TokenKind.NUMERIC, Errors.missingSymbol(TokenKind.NUMERIC.name));
        return new PrimaryExpression(token.value);
    }

    private Token get() {
        return scanner.getToken();
    }

    private Token next() {
        Token token = get();
        scanner.nextToken();
        return token;
    }

    private boolean check(TokenKind kind) {
        return get().kind == kind;
    }

    private Token expect(TokenKind kind, Error error) {
        if (check(kind)) {
            return next();
        }
        throw error(get(), error);
    }

    private ParseError error(Token token, Error error) {
        if (!(token.kind == TokenKind.ERROR)) {
            log.error(token.start, error);   
        }
        return new ParseError();
    }

}
