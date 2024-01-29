package org.deuxc.diagnostic;

import java.io.PrintWriter;

import org.deuxc.diagnostic.DxcDiagnostic.Error;

public class DefaultLogger implements Log {

    private char[] buffer;
    private PrintWriter err;

    public DefaultLogger(char[] array) {
        this(array, new PrintWriter(System.err, true));
    }

    public DefaultLogger(char[] array, PrintWriter err) {
        this.buffer = array;
        this.err = err;
    }

    @Override
    public void error(int pos, Error errorMessage) {
        Diagnostic diagnostic = new DxcDiagnostic(
                pos,
                errorMessage,
                new DiagnosticSource(buffer),
                new DefaultDiagnosticFormatter());
        err.println(diagnostic.toString());
    }
    
}
