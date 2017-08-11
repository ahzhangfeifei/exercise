package com.design.mode.state;

/**
 * The context for user useing
 */
public class ShopContext  {
    private ShopState currentState;

    /**
     * Instantiates a new Shop context.
     */
    public ShopContext() {
    }

    /**
     * Change state.
     *
     * @param s the s
     */
    public void changeState(ShopState s) {
        currentState = s;
    }

    /**
     * Shop.
     */
    public void shop() {
        currentState.shop();
    }

    /**
     * Generate bill.
     */
    public void generateBill() {
        currentState.generateBill();
    }

    /**
     * Pay.
     */
    public void pay() {
        currentState.pay();
    }
}