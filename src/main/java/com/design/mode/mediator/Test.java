package com.design.mode.mediator;

/**
 * 调停者模式
 * A test client
 */
public class Test  {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Mediator myMed = new ConcreteMediator();
        ColleagueA a = new ColleagueA(myMed);
        ColleagueB b = new ColleagueB(myMed);
        ColleagueC c = new ColleagueC(myMed);

        a.Change();
        b.Change();
        c.Change();
    }
}