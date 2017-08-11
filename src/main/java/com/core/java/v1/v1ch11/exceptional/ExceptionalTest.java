package com.core.java.v1.v1ch11.exceptional;

import java.util.Date;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * The type Exceptional test.
 */
public class ExceptionalTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int i = 0;
        int ntry = 10000000;
        Stack<String> s = new Stack<>();
        long s1;
        long s2;

        // test a stack for emptiness ntry times
        System.out.println("Testing for empty stack");
        s1 = new Date().getTime();
        for (i = 0; i <= ntry; i++)
            if (!s.empty()) s.pop();
        s2 = new Date().getTime();
        System.out.println((s2 - s1) + " milliseconds");

        // pop an empty stack ntry times and catch the resulting exception
        System.out.println("Catching EmptyStackException");
        s1 = new Date().getTime();
        for (i = 0; i <= ntry; i++) {
            try {
                s.pop();
            } catch (EmptyStackException e) {
            }
        }
        s2 = new Date().getTime();
        System.out.println((s2 - s1) + " milliseconds");
    }
}
