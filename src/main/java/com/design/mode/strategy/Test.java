package com.design.mode.strategy;

/**
 * 策略模式
 * A test client
 */
public class Test  {
        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
        int lineCount = 4;
        int lineWidth = 12;
        
        Context myContext = new Context();
        StrategyA strategyA = new StrategyA();
        StrategyB strategyB = new StrategyB();
        String s = "This is a test string ! This is a test string ! This is a test string ! This is a test string ! This is a test string ! This is a test string !";
        myContext.setText(s);
        myContext.setLineWidth(lineWidth);
        myContext.setStrategy(strategyA);
        myContext.drawText();

        myContext.setLineCount(lineCount);
        myContext.setStrategy(strategyB);
        myContext.drawText();
    }
}