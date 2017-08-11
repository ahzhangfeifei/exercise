package com.design.mode.chainofresponsibility;

/**
 * A member of the chain
 * The resposibility of Programmer is coding
 * Created by zhangfeifei on 2016/12/05.
 */

public class Programmer implements Chain {
    private Chain nextChain = null;
    private String responsibility = "Coding";

    /**
     * Instantiates a new Programmer.
     */
    public Programmer() {
    }
    public void addChain(Chain c) {
        nextChain = c;
    }
    
    public Chain getChain() {
        return nextChain;
    }
    
    public void sendToChain(String mesg) {
        if(mesg.equals(responsibility)) {
            System.out.println("A Programmer  -->  Coding");
        } else {
            if(nextChain != null) {
                nextChain.sendToChain(mesg);
            }
        }
    }
    
}
