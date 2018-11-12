package com.junitcourse._01_unit_test_and_tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    public void twoValidStrings() {
        StringUtils utils = new StringUtils();
        String str1 = "hello";
        String str2 = "world";
        String result = utils.concatLowerCase(str1, str2);
        assertThat(result).isEqualTo("helloworld");
    }

    @Test
    public void oneNullString() {
        StringUtils utils = new StringUtils();
        String result = utils.concatLowerCase("hello", null);
        assertThat(result).isEqualTo("hello");
        result = utils.concatLowerCase(null, "hello");
        assertThat(result).isEqualTo("hello");
    }

}
