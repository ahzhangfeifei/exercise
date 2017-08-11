package com.design.mode.templatemethod;

/**
 * An abstract class which can get content from a file or a HTTP URL
 * or other resource
 */
public abstract class AbstractRead {
    /**
     * The Resource.
     */
    protected String resource;

    /**
     * Gets content.
     */
    public void getContent() { // Template Method
        if(open()) {
            readContent();
            close();
        }
    }

    /**
     * Sets resource.
     *
     * @param s the s
     */
    public void setResource(String s) {
        resource = s;
    }

    /**
     * Open boolean.
     *
     * @return the boolean
     */
    protected abstract boolean open();

    /**
     * Read content.
     */
    protected abstract void readContent();

    /**
     * Close.
     */
    protected abstract void close();
}