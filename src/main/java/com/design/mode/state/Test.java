package com.design.mode.state;

/**
 * 状态模式
 * A test client
 */
public class Test  {
        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
        ShopContext myContext = new ShopContext();
        ShopState myShop = Shop.getInstance();
        ShopState myGenBill = GenerateBill.getInstance();
        ShopState myPay = Pay.getInstance();
        
        myContext.changeState(myShop);
        myContext.shop();

        myContext.changeState(myGenBill);
        myContext.generateBill();
        
        myContext.changeState(myPay);
        myContext.pay();

        myShop.changeState(myContext, myPay);
        myContext.pay();
    }
}