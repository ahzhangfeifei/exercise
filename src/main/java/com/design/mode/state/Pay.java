package com.design.mode.state;

/**
 * The type Pay.
 */
public class Pay extends ShopState {
    /**
     * The constant instanceFlag.
     */
    public static boolean instanceFlag = false; //true if have 1 instance
    private Pay() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Pay getInstance() {
        if(! instanceFlag) {
            instanceFlag = true;
            return new Pay();
        }
        return null;
    }
    public void pay() {
        System.out.println("The state is pay now !");
    }
}