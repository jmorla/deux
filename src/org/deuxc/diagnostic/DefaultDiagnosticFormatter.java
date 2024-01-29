package org.deuxc.diagnostic;

/**
 * Default implementation of the DiagnosticFormatter for formatting
 * DxcDiagnostic instances.
 */
public class DefaultDiagnosticFormatter implements DiagnosticFormatter<DxcDiagnostic> {

    /**
     * Formats the provided DxcDiagnostic into a string representation.
     *
     * @param diagnostic The DxcDiagnostic to be formatted.
     * @return A string representation of the formatted DxcDiagnostic.
     */
    @Override
    public String format(DxcDiagnostic diagnostic) {
        return diagnostic.getTemplate();
    }
    
}
