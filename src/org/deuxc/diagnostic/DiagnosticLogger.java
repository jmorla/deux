package org.deuxc.diagnostic;

import java.io.PrintWriter;

import org.deuxc.diagnostic.Diagnostic.Error;
import org.deuxc.diagnostic.Diagnostic.Fragments;

/**
 * The ConsoleLogger class implements the Log interface and provides a simple
 * console-based logging mechanism.
 */
public class DiagnosticLogger implements Log {

    private PrintWriter err;
    private DiagnosticSource diagnosticSource;

    /**
     * Constructs a ConsoleLogger with the specified DiagnosticSource.
     *
     * @param diagnosticSource The source of diagnostic information.
     */
    public DiagnosticLogger(DiagnosticSource diagnosticSource) {
        this(new PrintWriter(System.err, true), diagnosticSource);
    }

    /**
     * Constructs a ConsoleLogger with the specified PrintWriter and
     * DiagnosticSource.
     *
     * @param err              The PrintWriter used for error output.
     * @param diagnosticSource The source of diagnostic information.
     */
    public DiagnosticLogger(PrintWriter err, DiagnosticSource diagnosticSource) {
        this.err = err;
        this.diagnosticSource = diagnosticSource;
    }

    /**
     * Logs an error message along with diagnostic information at the specified
     * position.
     *
     * @param pos   The position of the error in the source code.
     * @param error The diagnostic error fragment to be logged.
     */
    public void error(int pos, Error error) {
        StringBuilder builder = new StringBuilder();
        builder.append(Fragments.locationFragment(
                diagnosticSource.fileName(),
                diagnosticSource.getLineNumber(pos),
                diagnosticSource.getColumnNumber(pos)).formatted());
        builder.append("  ");

        builder.append(error.formatted());

        appendDiagnosticPosition(builder, pos);

        err.println(builder);
    }

    /**
     * Logs an error message without any positional information.
     *
     * @param error The diagnostic error to be logged.
     */
    public void error(Error error) {
        err.println(error.formatted());
    }
    
    /**
     * Appends diagnostic information about the source code position to the given
     * StringBuilder.
     *
     * @param builder The StringBuilder to which the diagnostic information will be
     *                appended.
     * @param pos     The position in the source code for which diagnostic
     *                information is to be appended.
     */
    private void appendDiagnosticPosition(StringBuilder builder, int pos) {
        builder.append("\n");
        builder.append(Fragments.sourceLineFragment(diagnosticSource.getLineNumber(pos),
                diagnosticSource.getLine(pos).orElse("")).formatted());

        builder.append("\n");
        builder.append(Fragments.sourcePositionFragment(
                diagnosticSource.getLineNumber(pos),
                diagnosticSource.getColumnNumber(pos)).formatted());
    }
    
}
