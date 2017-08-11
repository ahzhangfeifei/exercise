package com.design.mode.chainofresponsibility;

/**
 * The end of the chain
 * The resposibility of Others is handle exeception
 * Created by zhangfeifei on 2016/12/05.
 */

public class Others implements Chain {
    private Chain nextChain = null;

    /**
     * Instantiates a new Others.
     */
    public Others() {
    }
    public void addChain(Chain c) {
        nextChain = c;
    }
    
    public Chain getChain() {
        return nextChain;
    }
    
    public void sendToChain(String mesg) {
            System.out.println("No one can handle -->  " + mesg);
    }
    
}