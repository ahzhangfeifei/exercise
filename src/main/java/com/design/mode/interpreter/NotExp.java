package com.design.mode.interpreter;

/**
 * A NonterminalExpression
 */
public class NotExp implements BooleanExp {
    private BooleanExp opernot1;
    //private BooleanExp operor2;

    /**
     * Instantiates a new Not exp.
     *
     * @param oper1 the oper 1
     */
    public NotExp(BooleanExp oper1) {
        opernot1 = oper1;
    }

    public boolean Evaluate(Context c) {
        return !(opernot1.Evaluate(c));
    }

    public BooleanExp Copy() {
        return new NotExp(opernot1.Copy());
    }

    public BooleanExp Replace(String var, BooleanExp exp) {
        return new NotExp(opernot1.Replace(var, exp));
    }
}