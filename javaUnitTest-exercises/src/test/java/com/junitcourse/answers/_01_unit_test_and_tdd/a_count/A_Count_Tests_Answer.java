package com.junitcourse.answers._01_unit_test_and_tdd.a_count;


public class A_Count_Tests_Answer {
    public static void main(String[] args) {
        // Add your tests here...

        StringCalc stringCalc = new StringCalc();
        int res;
        res = stringCalc.a_count("");

        if (res != 0){
            throw new AssertionError("Result should be 0");
        }

        res = stringCalc.a_count("a");

        if (res != 1){
            throw new AssertionError("Result should be 1");
        }

        res = stringCalc.a_count("Aa");

        if (res != 1){
            throw new AssertionError("Result should be 1");
        }

        res = stringCalc.a_count("aa");

        if (res != 2){
            throw new AssertionError("Result should be 2");
        }

        res = stringCalc.a_count("Car");

        if (res != 1){
            throw new AssertionError("Result should be 1");
        }

        res = stringCalc.a_count("vv123");

        if (res != 0){
            throw new AssertionError("Result should be 0");
        }
    }
}
