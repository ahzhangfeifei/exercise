package com.design.mode.composite;
/**
 *  A Component with some common function implementation
 *  You can abstract it.
 * Created by zhangfeifei on 2016/12/05.
 */
import java.util.*;

/**
 * The type Employee.
 */
public class Employee {
    /**
     * The Name.
     */
    String name;
    /**
     * The Salary.
     */
    float salary;
    /**
     * The Subordinates.
     */
    Vector subordinates;
    /**
     * The Is leaf.
     */
    boolean isLeaf;
    /**
     * The Parent.
     */
    Employee parent = null;

    /**
     * Instantiates a new Employee.
     *
     * @param _name   the name
     * @param _salary the salary
     */
//-------------------------------------------
    public Employee(String _name, float _salary) {
        name = _name;
        salary = _salary;
        subordinates = new Vector();
        isLeaf = false;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param _parent the parent
     * @param _name   the name
     * @param _salary the salary
     */
//-------------------------------------------
    public Employee(Employee _parent, String _name, float _salary) {
        name = _name;
        salary = _salary;
        parent = _parent;
        subordinates = new Vector();
        isLeaf = false;
    }

    /**
     * Sets leaf.
     *
     * @param b the b
     */
//-------------------------------------------
    public void setLeaf(boolean b) {
        isLeaf = b;    //if true, do not allow children
    }

    /**
     * Gets salary.
     *
     * @return the salary
     */
//-------------------------------------------
    public float getSalary() {
        return salary;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
//-------------------------------------------
    public String getName() {
        return name;
    }

    /**
     * Add boolean.
     *
     * @param e the e
     * @return the boolean
     */
//-------------------------------------------
    public boolean add(Employee e) {
        if (! isLeaf) { 
            subordinates.addElement(e);
        }
        return isLeaf;    //false if unsuccessful
    }

    /**
     * Remove.
     *
     * @param e the e
     */
//-------------------------------------------
    public void remove(Employee e) {
        if (! isLeaf) {
            subordinates.removeElement(e);
        }
    }

    /**
     * Elements enumeration.
     *
     * @return the enumeration
     */
//-------------------------------------------
    public Enumeration elements() {
        return subordinates.elements();
    }

    /**
     * Gets child.
     *
     * @param s the s
     * @return the child
     */
//-------------------------------------------
    public Employee getChild(String s) {
        Employee newEmp = null;

        if(getName().equals(s)) {
            return this;
        } else {
            boolean found = false;
            Enumeration e = elements();
            while(e.hasMoreElements() && (! found)) {  
                newEmp = (Employee)e.nextElement();
                found = newEmp.getName().equals(s);
                if (! found) {
                    newEmp = newEmp.getChild(s);
                    found =(newEmp != null);
                }
            }
            if (found) {
                return newEmp;
            } else {
                return null;
            }
        }
    }

    /**
     * Gets salaries.
     *
     * @return the salaries
     */
//-------------------------------------------
    public float getSalaries() {
        float sum = salary;
        for(int i = 0; i < subordinates.size(); i++) {
            sum += ((Employee)subordinates.elementAt(i)).getSalaries();
        }
        return sum;
    }
    
}