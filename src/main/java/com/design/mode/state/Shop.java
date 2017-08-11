package com.design.mode.state;

/**
 * The type Shop.
 */
public class Shop extends ShopState {
    /**
     * The constant instanceFlag.
     */
    public static boolean instanceFlag = false; //true if have 1 instance
    private Shop() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Shop getInstance() {
        if(! instanceFlag) {
            instanceFlag = true;
            return new Shop();
        }
        return null;
    }
    public void shop() {
        System.out.println("The state is shopping now !");
    }
}