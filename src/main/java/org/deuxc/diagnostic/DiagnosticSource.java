package main.java.org.deuxc.diagnostic;

import java.util.Optional;

/**
 * A simple abstraction of a source file, as needed for use in a diagnostic
 * message.
 * Provides access to the line and position in a line for any given character
 * offset.
 */
public class DiagnosticSource {

    private static final int TAB_SIZE = 4;

    /** A reference to the source code */
    private char[] buffer;

    /** The start of a line found by findLine. */
    private int lineStart;

    /** The line number of a line found by findLine. */
    private int line;

    private String fileName;

    public DiagnosticSource(char[] array) {
        this("", array);
    }


    public DiagnosticSource(String fileName, char[] content) {
        this.fileName = fileName;
        this.buffer = content;
    }

    /**
     * Retrieves the line number in the source code corresponding to the specified
     * position.
     *
     * @param pos The position in the source code for which to retrieve the line
     * number.
     * @return The line number associated with the specified position.
     */
    public int getLineNumber(int pos) {
        if (findLine(pos)) {
            return line;
        }
        return 0;
    }

    /**
     * Gets the column number corresponding to the given position in the source
     * code.
     *
     * @param pos The position in the source code for which to retrieve the column
     * @return The column number associated with the specified position.
     */
    public int getColumnNumber(int pos) {
        if (!findLine(pos)) {
            return 0;
        }
        int column = 0;
        for (int i = lineStart; i < pos; i++) {
            if (buffer[i] == '\t') {
                column += TAB_SIZE;
            } else {
                column++;
            }
        }
        return column + 1;
    }

    /**
     * Retrieves the line of source code containing the specified position.
     *
     * @param pos The position in the source code for which to retrieve the line.
     * @return An Optional containing the source code line if the position is valid,
     * or an empty Optional otherwise.
     */
    public Optional<String> getLine(int pos) {
        if (!findLine(pos)) {
            Optional.empty();
        }

        int lineEnd = lineStart, length = buffer.length;

        while (lineEnd < length && buffer[lineEnd] != '\n') {
            lineEnd++;
        }
        if (lineEnd - lineStart == 0)
            return Optional.empty();

        return Optional.of(new String(buffer, lineStart, lineEnd - lineStart));

    }

    /**
     * Determines if the specified position is within the valid range of source code
     * lines.
     *
     * @param pos The position in the source code for which to check validity.
     * @return true if the position is within the valid range, false otherwise.
     */
    private boolean findLine(int pos) {
        int length = buffer.length;
        if (pos >= length) {
            return false;
        }

        int line = 1;
        for (int i = 0; i < pos; i++) {
            if (buffer[i] == '\n') {
                line++;
                lineStart = i + 1; // jump nl
            }
        }

        this.line = line;
        return true;
    }

    public String fileName() {
        return this.fileName;
    }


}
