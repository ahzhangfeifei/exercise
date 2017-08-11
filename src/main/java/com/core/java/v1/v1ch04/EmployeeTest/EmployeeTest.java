package com.core.java.v1.v1ch04.EmployeeTest;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * The type Employee test.
 */
public class EmployeeTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        // raise everyone's salary by 5%
        for (Employee e : staff)
            e.raiseSalary(5);

        // print out information about all Employee objects
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
                    + e.getHireDay());
    }
}

/**
 * The type Employee.
 */
class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    /**
     * Instantiates a new Employee.
     *
     * @param n     the n
     * @param s     the s
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        // GregorianCalendar uses 0 for January
        hireDay = calendar.getTime();
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets hire day.
     *
     * @return the hire day
     */
    public Date getHireDay() {
        return hireDay;
    }

    /**
     * Raise salary.
     *
     * @param byPercent the by percent
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
