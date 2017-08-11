package com.design.mode.visitor;

/**
 * The type Vacation visitor.
 */
public class VacationVisitor extends Visitor {
    /**
     * The Total days.
     */
    protected int total_days;

    /**
     * Instantiates a new Vacation visitor.
     */
    public VacationVisitor() {
        total_days = 0;
    }

    public void visit(Employee emp) {
        total_days += emp.getVacDays();
    }

    public void visit(Boss boss) {
        total_days += boss.getVacDays();
    }

    /**
     * Gets total days.
     *
     * @return the total days
     */

    public int getTotalDays() {
        return total_days;
    }
}
