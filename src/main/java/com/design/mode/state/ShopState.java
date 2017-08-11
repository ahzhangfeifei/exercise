package com.design.mode.state;

/**
 * The parent class of state
 */
public class ShopState implements IShopState {
    /**
     * Instantiates a new Shop state.
     */
    public ShopState() {
    }
    public void shop() { }
    public void generateBill() { }
    public void pay() { }

    /**
     * Change state.
     *
     * @param c the c
     * @param s the s
     */
    protected void changeState(ShopContext c, ShopState s) {
        c.changeState(s);
    }
}