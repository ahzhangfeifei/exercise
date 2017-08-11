package com.design.mode.state;

/**
 * The type Generate bill.
 */
public class GenerateBill extends ShopState {
    /**
     * The constant instanceFlag.
     */
    public static boolean instanceFlag = false; //true if have 1 instance
    private GenerateBill() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static GenerateBill getInstance() {
        if(! instanceFlag) {
            instanceFlag = true;
            return new GenerateBill();
        }
        return null;
    }
    public void generateBill() {
        System.out.println("The state is generating bill now !");
    }
}
