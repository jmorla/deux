package org.deuxc.compiler;

import org.deuxc.tree.AbstractVisitor;
import org.deuxc.tree.DeuxTree.CompilationUnit;

/**
 * This class represents a symbol table and extends the AbstractVisitor class.
 * It is responsible for entering symbols for all encountered definitions into
 * the symbol table.
 */
public class SymbolTable extends AbstractVisitor {

  
    /**
     * Completes the symbol table by processing the given compilation unit.
     * This method should be called after all symbols have been added to the table.
     *
     * @param unit the compilation unit to be processed
     */
    public void complete(CompilationUnit unit) {}
    
}
