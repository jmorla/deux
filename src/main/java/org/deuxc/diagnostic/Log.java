package main.java.org.deuxc.diagnostic;

import main.java.org.deuxc.diagnostic.Diagnostic.Error;

/**
 * Interface for logging messages in the Deuxc compiler.
 * Implementations of this interface provide methods to log informational,
 * verbose, and warning messages during the compilation process.
 * 
 * @author Jorge Morla
 */
public interface Log {

    /**
     * Logs an error.
     *
     * @param pos   The position the error happened
     * @param error The error to be logged.
     */
    void error(int pos, Error error);

}
