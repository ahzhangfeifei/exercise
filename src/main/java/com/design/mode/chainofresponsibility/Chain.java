package com.design.mode.chainofresponsibility;

/**
 * The interface of the chain
 * You can use AddChain function to modify the chain dynamically
 * Created by zhangfeifei on 2016/12/05.
 */
public interface Chain  {
    /**
     * Add chain.
     *
     * @param c the c
     */
    public abstract void addChain(Chain c);

    /**
     * Send to chain.
     *
     * @param mesg the mesg
     */
    public abstract void sendToChain(String mesg);

    /**
     * Gets chain.
     *
     * @return the chain
     */
    public abstract Chain getChain();
}