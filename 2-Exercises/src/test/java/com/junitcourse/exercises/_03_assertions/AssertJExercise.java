package com.junitcourse.exercises._03_assertions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExercise {

    @Test
    public void numberWith2DigitsTest() {
        int num = 44;

        // Add assertion using AssertJ that num contains 2 digits
    }

    @Test
    public void twoStringsSameLengthTest() {
        String s1 = "Bug";
        String s2 = "Dog";

        // Add assertion using AssertJ that the the 2 strings has the same length
    }

    @Test
    public void assertArray(){
        String [] names = {"Gidi", "Dani", "Yoni", "Alon"};

        // Add assertion using AssertJ that verifies:
        // - The array is not empty
        // - The array does not have duplicate values
        // - The array have 4 elements
        // - The arrays contains the values  "Yoni" and "Gidi"
    }

}
