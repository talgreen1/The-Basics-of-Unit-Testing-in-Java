package com.junitcourse._03_assertions;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertionsIntro {
    public static void main(String[] args) {
        int num = 10;

        // We want to assert that num value is 10

        // using plain Java
        if (num != 10){
            throw new AssertionError("Value of num is " + num+ " and should be 10");
        }

        // Using JUnit assert
        Assert.assertEquals(num, 10);
        Assert.assertEquals("Asserting num",num, 10);

        // Using AssertJ
        assertThat(num).isEqualTo(10);
        assertThat(num).as("Asserting value of num").isEqualTo(10);
    }
}
