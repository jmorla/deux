package org.deuxc.parser;

import java.io.BufferedReader;
import java.io.Reader;

import org.deuxc.logger.Log;

/**
 * An abstract base class for tokenizer. This class provides a foundation 
 * for implementing specialized common functionalities.
 * 
 */
public abstract class BaseReader {

    /**
     * Log for error reporting.
     */
    private final Log log;

    /**
     * Buffer containing characters from source file.
     */
    private final BufferedReader buffer;

    /**
     * Constructor.
     * 
     * @param log    Log for error reporting
     * @param source Reader containin source
    */
    protected BaseReader(Log log, Reader source) {
        this.log = log;
        buffer = new BufferedReader(source);
    }
    
}
