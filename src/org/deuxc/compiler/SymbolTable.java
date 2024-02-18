package org.deuxc.compiler;

import java.util.HashMap;
import java.util.Map;

import org.deuxc.compiler.Symbol.VarSymbol;

/**
 * The SymbolTable class represents a symbol table.
 * This class provides functionalities to store and retrieve symbols.
 */
public class SymbolTable {

    private final Map<String, VarSymbol> vars = new HashMap<>();
 
    public void insertVar(VarSymbol sym) {}
}
