package org.deuxc.diagnostic;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

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
        var template = diagnostic.getTemplate();
        var args = diagnostic.getArgs();
        
        String message = MessageFormat.format(template, (Object[]) args);
        message = message.replace("$file", "sample.de");
        message = message.replace("$line", String.valueOf(diagnostic.getLineNumber()));
        message = message.replace("$column", String.valueOf(diagnostic.getColumnNumber()));
        message = message.replace("$code", diagnostic.getLineCode());
        return message;
    }    
}
