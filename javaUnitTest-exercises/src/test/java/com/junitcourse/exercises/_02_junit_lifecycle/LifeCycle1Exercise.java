package com.junitcourse.exercises._02_junit_lifecycle;

import org.junit.Test;

/**
 * Add before / after methods so that a message is printed to the console ONCE
 * before the tests, and another message after EACH test.
 */
public class LifeCycle1Exercise {

    @Test
    public void test1() {
        System.out.println("Running test1!");
    }

    @Test
    public void test2() {
        System.out.println("Running test2!");
    }

}
