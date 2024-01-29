package org.deuxc.diagnostic;


import org.deuxc.diagnostic.DxcDiagnostic.Error;

public interface DiagnosticMessages {
    public static abstract class Errors {

        private static String ILLEGAL_SYMBOL_MESSAGE = "{0}:{1}:{2} error: '{3}' invalid symbol";

        /**
         * Creates an error diagnostic indicating an illegal symbol
         *
         * @param symbol The symbol that is considered illegal.
         * @return An Error instance representing the diagnostic information for the
         * illegal symbol.
         */
        public static Error illegalSymbolError(String symbol) {
            return new Error(ILLEGAL_SYMBOL_MESSAGE, new String[] { symbol });
        }
    }
    
}
