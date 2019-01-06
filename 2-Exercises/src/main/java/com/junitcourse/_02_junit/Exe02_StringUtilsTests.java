package com.junitcourse._02_junit;

import com.junitcourse._01_testing_our_code.Exe01_StringUtils;

public class Exe02_StringUtilsTests {
    public static void main(String[] args) {
        Exe02_StringUtils stringUtils = new Exe02_StringUtils();

        String res = null;

        res = stringUtils.concatLowerCase("a", "b");

        if (!res.equals("ab")){
            throw new AssertionError("Result should be 'ab'");
        }


        res = stringUtils.concatLowerCase("a",null);

        if (!res.equals("a")){
            throw new AssertionError("Result should be 'a'");
        }

        res = stringUtils.concatLowerCase(null, "a");

        if (!res.equals("a")){
            throw new AssertionError("Result should be 'a'");
        }

        res = stringUtils.concatLowerCase("a", "B");

        if (!res.equals("ab")){
            throw new AssertionError("Result should be 'ab'");
        }

        res = stringUtils.concatLowerCase("A", "b");

        if (!res.equals("ab")){
            throw new AssertionError("Result should be 'ab'");
        }

    }
}
