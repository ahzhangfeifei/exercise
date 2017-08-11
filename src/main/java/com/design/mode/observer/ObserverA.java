package com.design.mode.observer;

import java.util.Vector;

/**
 *  A concrete observer A
 *  This concrete observer can change subject through call
 *  a concrete subject setState function
 */
public class ObserverA implements Observer {
    private Vector strVector;
    private Subject sub;

    /**
     * Instantiates a new Observer a.
     *
     * @param s the s
     */
    public ObserverA(Subject s) {
        sub = s;
        //strVector = new Vector();
    }
    public void update(Subject subject) {
        strVector = subject.getState();
        System.out.println("----- ObserverA will be updated -----");
        for(int i = 0; i < strVector.size(); i++) {
            System.out.println("Num " + i + " is :" + (String)strVector.get(i));
        }
    }

    /**
     * Change.
     *
     * @param action the action
     * @param str    the str
     */
    public void change(String action, String str) {
        sub.setState(action, str);
        //we can auto update
        //sub.sendNotify();
    }

    /**
     * Notify sub.
     */
    public void notifySub() {
        sub.sendNotify();
    }
}