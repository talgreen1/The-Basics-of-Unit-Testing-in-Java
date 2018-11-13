package com.junitcourse._01_unit_test_and_tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {
    @Test
    public void Given_2_strings_When_calling_concatLowerCase_Then_you_get_a_concatination_of_them_both() {
        StringUtils utils = new StringUtils();
        String str1 = "Hello";
        String str2 = "WORLD";
        String result = utils.concatLowerCase(str1, str2);
        assertThat(result).isEqualTo("helloworld");
    }

    @Test
    public void Given_one_string_and_one_null_When_calling_concatLowerCase_Then_you_get_the_string_in_lowercase() {
        StringUtils utils = new StringUtils();
        String result = utils.concatLowerCase("HELLO", null);
        assertThat(result).isEqualTo("hello");
        result = utils.concatLowerCase(null, "HELLO");
        assertThat(result).isEqualTo("hello");
    }

}
