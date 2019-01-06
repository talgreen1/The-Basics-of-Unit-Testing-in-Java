package com.junitcourse.answers._01_unit_test_and_tdd.a_count;

public class StringCalcAnswer {

    public int a_count(String str){
        int originalLength = str.length();
        int lenghtAfterRemoveAllA = str.replaceAll("a", "").length();

        return originalLength-lenghtAfterRemoveAllA;

    }
}
