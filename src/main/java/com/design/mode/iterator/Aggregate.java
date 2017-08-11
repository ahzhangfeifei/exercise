package com.design.mode.iterator;

/**
 * The interface to create concrete iterator
 * When create iterator, we can use Factory Method pattern
 */
public interface Aggregate  {
    /**
     * Create iterator iterator.
     *
     * @return the iterator
     */
    public Iterator CreateIterator();
}