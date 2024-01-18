package org.deuxc.parser;

import java.io.BufferedReader;
import java.io.IOException;
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
     * Current character being observed
    */
    private char character;


    /**
     * Codepoint of character currently being observed.
     */
    private int codepoint;

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


    /**
     * Retrieves current character observed
     *
     * @return The character value.
     */
    protected char get() {
        return character;
    }


    /**
     * Retrieves the Unicode code point of the current character
     *
     * @return The Unicode code point value.
     */
    protected int getCodePoint() {
        return codepoint;
    }

    /**
     * Advances the reader to the next character and returns it.
     * This method updates the internal state of the reader.
     *
     * @return The next character in the buffer.
     */
    protected char next() {
        nextCodePoint();

        return character;
    }


    /**
     * Reads the next Unicode code point from the buffer, updates
     * the internal state, and returns the code point.
     *
     * @return The Unicode code point read from the buffer.
     */
    protected int nextCodePoint() {
        codepoint = read();
        character = (char) codepoint;

        return codepoint;
    }


    /**
     * Reads the next integer from the input buffer.
     * 
     * @return The next integer read from the input buffer. Returns -1 if an
     *         IOException occurs during the read operation.
     */
    private int read() {
        try {
            return buffer.read();
        } catch (IOException ex) {
            return -1;
        }
    }
    
}
