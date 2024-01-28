package org.deuxc.diagnostic;

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
     * @param pos The position the error happened
     * @param error The error to be logged.
     */
    void error();


    /**
     * Logs an warning.
     *
     * @param pos The position the warning happened
     * @param warn The warning to be logged.
     */
    void warn();
}
