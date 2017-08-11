package com.design.mode.visitor;

/**
 * The type Employee.
 */
public class Employee {
    /**
     * The Sick days.
     */
    int sickDays, /**
     * The Vac days.
     */
    vacDays;
    /**
     * The Salary.
     */
    float Salary;
    /**
     * The Name.
     */
    String Name;

    /**
     * Instantiates a new Employee.
     *
     * @param name     the name
     * @param salary   the salary
     * @param vacdays  the vacdays
     * @param sickdays the sickdays
     */
    public Employee(String name, float salary, int vacdays, int sickdays) {
        vacDays = vacdays;
        sickDays = sickdays;
        Salary = salary;
        Name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * Gets sickdays.
     *
     * @return the sickdays
     */
    public int getSickdays() {
        return sickDays;
    }

    /**
     * Gets vac days.
     *
     * @return the vac days
     */
    public int getVacDays() {
        return vacDays;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public float getSalary() {
        return Salary;
    }

    /**
     * Accept.
     *
     * @param v the v
     */
    public void accept(Visitor v) {
        v.visit(this);
    }
}
