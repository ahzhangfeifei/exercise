package com.design.mode.interpreter;


/**
 * The interface of our BooleanExp Interpreter
 * BooleanExp definition is:
 * BooleanExp ::= VariableExp | Constant | OrExp | AndExp
 * | NotExp | '(' BooleanExp ')'
 * AndExp ::= BooleanExp 'and' BooleanExp
 * OrExp ::= BooleanExp 'or' BooleanExp
 * NotExp ::= BooleanExp 'not' BooleanExp
 * Constant ::= 'true' | 'false'
 * VariableExp ::= 'A' | 'B' | ... | 'Z'
 */
public interface BooleanExp {
    /**
     * Evaluate boolean.
     *
     * @param c the c
     * @return the boolean
     */
    public abstract boolean Evaluate(Context c);

    /**
     * Replace boolean exp.
     *
     * @param var the var
     * @param exp the exp
     * @return the boolean exp
     */
    public abstract BooleanExp Replace(String var, BooleanExp exp);

    /**
     * Copy boolean exp.
     *
     * @return the boolean exp
     */
    public abstract BooleanExp Copy();
}