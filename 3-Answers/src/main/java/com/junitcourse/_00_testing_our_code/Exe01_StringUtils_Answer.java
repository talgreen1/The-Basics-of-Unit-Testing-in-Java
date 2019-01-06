package com.junitcourse._00_testing_our_code;

public class Exe01_StringUtils_Answer {
    public String concatLowerCase(String str1, String str2){
        String result;

        if (str1 == null){
            result = str2;
        } else   if (str2 == null){
            result = str1;
        }
        else {
            result = str1 + str2;
        }

        return result.toLowerCase();
    }
}
