package org.deuxc.compiler;

import java.io.Writer;

import org.deuxc.tree.AbstractVisitor;
import org.deuxc.tree.DeuxTree.CompilationUnit;

/**
 * Generator is responsible for compiling Deux programming language code into
 * machine code.
 */
public class Generator extends AbstractVisitor {
    
    public void generate(CompilationUnit unit, SymbolTable symbtab, Writer out) {

    }
}
