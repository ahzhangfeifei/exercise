package com.core.java.v1.v1ch04.PackageTest;

import com.core.java.v1.v1ch04.PackageTest.com.horstmann.corejava.*;

import static java.lang.System.out;

// the Employee class is defined in that package com.core.java.v1.v1ch04.


/**
 * The type Package test.
 */
public class PackageTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // because of the import statement, we don't have to use com.horstmann.corejava.Employee here
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        harry.raiseSalary(5);

        // because of the static import statement, we don't have to use System.out here
        out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
    }
}
