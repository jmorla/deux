package org.deuxc.diagnostic;

/**
 * Represents a generic diagnostic formatter for formatting diagnostics of type
 * {@code D}.
 *
 * @param <D> The type of diagnostic that this formatter can handle.
 */
public interface DiagnosticFormatter<D extends Diagnostic> {
    
    /**
     * Formats the provided diagnostic into a string representation.
     *
     * @param diagnostic The diagnostic to be formatted.
     * @return A string representation of the formatted diagnostic.
     */
    String format(D diagnostic);
    
}
