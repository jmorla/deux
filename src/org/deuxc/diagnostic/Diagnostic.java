package org.deuxc.diagnostic;

/**
 * Utility class for generating diagnostic messages and fragments.
 */
public class Diagnostic {
    
    /**
     * Utility class for generating error messages.
     */
    public static final class Errors {

        public static DiagnosticFragment illegalSymbolError(String symbol) {
            return new DiagnosticFragment(
                    "Error '%s' illegal symbol", symbol);
        }
    }


    /**
     * Utility class for generating fragments of diagnostic information.
     */
    public static final class Fragments {

        /**
         * Creates a diagnostic fragment for the location (file, line, and column)
         * information.
         *
         * @param fileName     The name of the file.
         * @param lineNumber   The line number.
         * @param columnNumber The column number.
         * @return A diagnostic fragment for location information.
         */
        public static DiagnosticFragment locationFragment(
                String fileName, int lineNumber, int columnNumber) {
            return new DiagnosticFragment("%s:%d:%d", fileName, lineNumber, columnNumber);
        }

        /**
         * Creates a diagnostic fragment for a source code line.
         *
         * @param lineNumber The line number.
         * @param lineCode   The source code line.
         * @return A diagnostic fragment for a source code line.
         */
        public static DiagnosticFragment sourceLineFragment(int lineNumber, String lineCode) {
            var size = String.valueOf(lineNumber).length();
            return new DiagnosticFragment("   %-" + size + "d | %-40s", lineNumber, lineCode);
        }
        
        /**
         * Creates a diagnostic fragment for highlighting a specific source code
         * position.
         *
         * @param pos The position to highlight in the source code.
         * @return A diagnostic fragment for highlighting a source code position.
         */
        public static DiagnosticFragment sourcePositionFragment(int lineNumber, int pos) {
            var size = String.valueOf(lineNumber).length();
            return new DiagnosticFragment("   %-" + size + "s | " + "%-" + pos + "s^", "", "");
        }
    }

    /**
     * Represents a fragment of a diagnostic message.
     */
    public static class DiagnosticFragment {
        private String message;
        private Object[] args;

        /**
         * Constructs a diagnostic fragment with a message and optional arguments.
         *
         * @param message The message template.
         * @param args    Optional arguments to be inserted into the message template.
         */
        public DiagnosticFragment(String message, Object... args) {
            this.message = message;
            this.args = args;
        }

        /**
         * Gets the arguments of the diagnostic fragment.
         *
         * @return An array of arguments.
         */
        public Object[] getArg() {
            return args;
        }

        /**
         * Formats the diagnostic fragment into a complete message.
         *
         * @return The formatted diagnostic message.
         */
        public String formatted() {
            return String.format(message, args);
        }
    }


}
