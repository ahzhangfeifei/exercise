package com.design.mode.singleton;

/**
 * A Singleton , we can only create one instance
 */
public class SingletonA  {
    /**
     * The constant instanceFlag.
     */
    public static boolean instanceFlag = false; //true if 1 instance
    
    private int i = 0;
    
    private SingletonA() {
    }

    /**
     * Gets num.
     *
     * @return the num
     */
    public int getNum() {
        return i;
    }

    /**
     * Sets num.
     */
    public void setNum() {
        i++;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static SingletonA getInstance() {
        if(! instanceFlag) {
            instanceFlag = true;
            return new SingletonA();
        }
        return null;
    }

    public void finalize() {
        instanceFlag = false;
    }
}