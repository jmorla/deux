package main.java.org.deuxc.diagnostic;


public class LoggerFactory {
    
    public DiagnosticLogger getInstance(String fileName, char[] source) {
        DiagnosticSource diagSource = new DiagnosticSource(fileName, source);
        return new DiagnosticLogger(diagSource);
    }
}
