package com.junitcourse._03_assertions;

import com.junitcourse._02_junit.Exe03_StringUtils_Answer;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exe05_StringUtilsTest_Answer {

    private static Exe03_StringUtils_Answer stringUtils;

    @BeforeClass
    public static void setup() {
        stringUtils = new Exe03_StringUtils_Answer();
    }

    @Test
    public void two_valid_chars() {
        String res = null;

        res = stringUtils.concatLowerCase("a", "b");

        assertThat(res).isEqualTo("ab");
    }

    @Test
    public void valid_string_and_null() {
        String res = stringUtils.concatLowerCase("cat", null);

        assertThat(res).isEqualTo("cat");
    }

    @Test
    public void null_and_valid_string() {
        String res = stringUtils.concatLowerCase(null, "cat");

        assertThat(res).isEqualTo("cat");
    }

    @Test
    public void lower_case_string_and_upper_case_string() {
        String res = stringUtils.concatLowerCase("hello", " WORLD");

        assertThat(res).isEqualTo("hello world");
    }

    @Test
    public void upper_case_string_and_lower_case_string() {
        String res = stringUtils.concatLowerCase("HELLO", " world");

        assertThat(res).isEqualTo("hello world");
    }

}
