package org.deuxc.tree;

/**
 * An interface for objects that can be visited by a Visitor.
 */
public interface Visitable {
    
    /**
     * Accepts a Visitor, allowing it to perform operations on the implementing
     * object.
     *
     * @param visitor The Visitor to be accepted.
     */
    void accept(Visitor t);
}
