package com.junitcourse._00_testing_our_code;

public class Exe01_StringUtilsTests_Answer {
    public static void main(String[] args) {
        Exe01_StringUtils_Answer stringUtils = new Exe01_StringUtils_Answer();

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
