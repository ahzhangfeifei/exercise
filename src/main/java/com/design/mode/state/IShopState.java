package com.design.mode.state;

/**
 * A state interface
 */
public interface IShopState {
    /**
     * Shop.
     */
    void shop();

    /**
     * Generate bill.
     */
    void generateBill();

    /**
     * Pay.
     */
    void pay();
    //protected void changeState(ShopContext c, IShopState);
}