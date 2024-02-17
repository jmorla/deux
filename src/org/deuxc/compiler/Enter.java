package org.deuxc.compiler;

import org.deuxc.tree.AbstractVisitor;
import org.deuxc.tree.DeuxTree.CompilationUnit;

/**
 * The Enter class is responsible for generating the symbol table.
 * This class extends AbstractVisitor to provide additional functionality.
 */
public class Enter extends AbstractVisitor {

    private SymbolTable symtab;
    /**
     * Completes the symbol table by processing the given compilation unit.
     * This method should be called after all symbols have been added to the table.
     *
     * @param unit the compilation unit to be processed
     */
    public void complete(CompilationUnit unit) {
    }
    
    public SymbolTable getSimbtab() {
        return symtab;
    }

    public boolean isCompleted() {
        return false;
    }
    
}
