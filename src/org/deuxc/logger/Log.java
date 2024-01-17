package org.deuxc.logger;

/**
 * Interface for logging messages in the Deuxc compiler.
 * Implementations of this interface provide methods to log informational,
 * verbose, and warning messages during the compilation process.
 * 
 * @author Jorge Morla
 */
public interface Log {

    /**
     * Logs an informational message.
     *
     * @param message The informational message to be logged.
     */
    void info(String message);

    /**
     * Logs a error message.
     *
     * @param message The error message to be logged.
     */
    void error(String message);

    /**
     * Logs a warning message.
     *
     * @param message The warning message to be logged.
     */
    void warning(String message);
    
}
