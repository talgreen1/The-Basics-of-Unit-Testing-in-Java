package com.junitcourse._03_assertions;

import com.junitcourse._02_junit.Exe03_StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;

public class Exe05_StringUtilsTest {

    private static Exe03_StringUtils stringUtils;

    @BeforeClass
    public static void setup() {
        stringUtils = new Exe03_StringUtils();
    }

    @Test
    public void two_valid_chars() {
        String res = null;

        res = stringUtils.concatLowerCase("a", "b");

        if (!res.equals("ab")) {
            throw new AssertionError("Result should be 'ab'");
        }
    }

    @Test
    public void valid_string_and_null() {
        String res = stringUtils.concatLowerCase("cat", null);

        if (!res.equals("cat")) {
            throw new AssertionError("Result should be 'cat'");
        }
    }

    @Test
    public void null_and_valid_string() {
        String res = stringUtils.concatLowerCase(null, "cat");

        if (!res.equals("cat")) {
            throw new AssertionError("Result should be 'cat'");
        }
    }

    @Test
    public void lower_case_string_and_upper_case_string() {
        String res = stringUtils.concatLowerCase("hello", " WORLD");

        if (!res.equals("hello world")) {
            throw new AssertionError("Result should be 'hello world'");
        }
    }

    @Test
    public void upper_case_string_and_lower_case_string() {
        String res = stringUtils.concatLowerCase("HELLO", " world");

        if (!res.equals("hello world")) {
            throw new AssertionError("Result should be 'hello world'");
        }
    }

}
