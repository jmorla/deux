package org.deuxc.diagnostic;


import org.deuxc.diagnostic.DxcDiagnostic.Error;

public interface DiagnosticMessages {
    public static abstract class Errors {

        private static String ILLEGAL_SYMBOL_TEMPLATE = "{0}:{1}:{2} error: '{3}' invalid symbol";

        static Error illegalSymbolError(String symbol) {
            return new Error(ILLEGAL_SYMBOL_TEMPLATE, new String[] { symbol });
        } 
    }
    
}
