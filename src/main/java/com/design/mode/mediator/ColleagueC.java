package com.design.mode.mediator;

/**
 *  A concrete colleague
 */
public class ColleagueC implements Colleague {
    private final String type = "C";
    private Mediator med;

    /**
     * Instantiates a new Colleague c.
     *
     * @param m the m
     */
    public ColleagueC(Mediator m) {
        med = m;
        med.Register(this, type);
    }
    public void Change() {
        System.out.println("-----  C changed now !  -----");
        med.Changed(type);
    }
    public void Action() {
        System.out.println("  C is changed by mediator ");
    }
}