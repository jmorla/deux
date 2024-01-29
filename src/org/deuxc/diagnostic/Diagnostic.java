package org.deuxc.diagnostic;

/**
 * Interface for diagnostics from tools. A diagnostic usually reports
 * a problem at a specific position in a source file
 */
public interface Diagnostic {

    enum DiagnosticType {

        ERROR
    }


    DiagnosticType getType();

    long getPosition();

    long getLineNumber();

    String getLineCode();

    long getColumnNumber();
   
}
