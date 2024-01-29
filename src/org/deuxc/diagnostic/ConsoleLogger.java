package org.deuxc.diagnostic;

import java.io.PrintWriter;

import org.deuxc.diagnostic.Diagnostic.DiagnosticFragment;
import org.deuxc.diagnostic.Diagnostic.Fragments;


public class ConsoleLogger implements Log {

    private PrintWriter err;
    private DiagnosticSource diagnosticSource;

    public ConsoleLogger(DiagnosticSource diagnosticSource) {
        this(new PrintWriter(System.err, true), diagnosticSource);
    }

    public ConsoleLogger(PrintWriter err, DiagnosticSource diagnosticSource) {
        this.err = err;
        this.diagnosticSource = diagnosticSource;
    }

    public void error(int pos, DiagnosticFragment error) {
        StringBuilder builder = new StringBuilder();
        builder.append(Fragments.locationFragment(
                diagnosticSource.fileName(),
                diagnosticSource.getLineNumber(pos),
                diagnosticSource.getColumnNumber(pos)).formatted());
        builder.append("  ");

        builder.append(error.formatted());

        builder.append("\n");
        builder.append(Fragments.sourceLineFragment(diagnosticSource.getLineNumber(pos),
                diagnosticSource.getLine(pos).orElse("")).formatted());

        builder.append("\n");
        builder.append(Fragments.sourcePositionFragment(
                diagnosticSource.getLineNumber(pos),
            diagnosticSource.getColumnNumber(pos)).formatted());

        err.println(builder);
    }
    
}
