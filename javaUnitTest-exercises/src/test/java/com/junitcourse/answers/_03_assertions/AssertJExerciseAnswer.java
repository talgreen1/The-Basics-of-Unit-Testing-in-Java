package com.junitcourse.answers._03_assertions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExerciseAnswer {

    @Test
    public void numberWith2DigitsTest() {
        int num = 44;

        // Add assertion using AssertJ that num contains 2 digits
        assertThat(num).isGreaterThanOrEqualTo(10).isLessThan(100);
    }

    @Test
    public void twoStringsSameLenghtTest() {
        String s1 = "Bug";
        String s2 = "Dog";

        // Add assertion using AssertJ that the the 2 strings has the same length
        assertThat(s1.length()).isEqualTo(s2.length());
    }

}
