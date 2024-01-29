package org.deuxc.diagnostic;


import org.deuxc.diagnostic.DxcDiagnostic.Error;

public interface DiagnosticMessages {
    public static abstract class Errors {

        private static String ILLEGAL_SYMBOL_MESSAGE = """
            $file:  $line:$column:  Error: `{0}` invalid symbol
                $line| $code
                    |""";
                

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
