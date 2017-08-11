package com.design.mode.interpreter;

/**
 *解释器模式
 */
public class Test  {
        /**
         * The entry point of application.
         *
         * @param args the input arguments
         */
        public static void main(String[] args) {
        // Test :
        //         (true and x) and (y and (not x))
        Context context = new Context();
       
        VariableExp x = new VariableExp("X");
        VariableExp y = new VariableExp("Y");
        VariableExp bTure = new VariableExp("true");
        VariableExp bFalse = new VariableExp("false");

        context.Assign("true", true);
        context.Assign("false", false);
        context.Assign("X", false);
        context.Assign("Y", true);
        
        BooleanExp expression = new AndExp(
            new AndExp(bTure, x),
            new AndExp(y, new NotExp(x))
        );
        boolean result = expression.Evaluate(context);
        System.out.println("The result is:" + result);
    }
}