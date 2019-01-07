package com.junitcourse._02_junit;

public class Exe03_StringUtils {
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
