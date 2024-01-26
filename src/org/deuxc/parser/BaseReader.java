package org.deuxc.parser;

import org.deuxc.logger.Log;

/**
 * An abstract base class for tokenizer. This class provides a foundation 
 * for implementing specialized common functionalities.
 * 
 */
public abstract class BaseReader {


    /** 
     * End of input character. 
     * Used to denote the last defined character in a source file.
     */
    public final byte EOF = 0x1A;

    /**
     * Log for error reporting.
     */
    protected final Log log;

    /**
     * Buffer containing characters from source file.
     */
    private final char[] buffer;

    
    /**
     * Current character being observed
    */
    private char character;

    /**
     * Character buffer index of character currently being observed.
     */
    private int position;

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
    protected BaseReader(Log log, char[] array) {
        this.log = log;
        buffer = array;
        position = 0;

        nextCodePoint();
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
        if(buffer.length <= position) {
            character = EOF;
        } else {
            character = buffer[position ++]; 
        }
        codepoint = (int) character;

        return codepoint;
    }
    
}
