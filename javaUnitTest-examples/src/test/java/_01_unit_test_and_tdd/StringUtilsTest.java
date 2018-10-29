package _01_unit_test_and_tdd;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringUtilsTest {

    @Test
    public void twoValidStrings(){
        StringUtils utils = new StringUtils();

        String str1 = "hello";
        String str2 = "world";

        String result = utils.coctacLowerCase(str1, str2);

        assertThat(result).isEqualTo("helloworld");
    }

    @Test
    public void oneNullString(){
        StringUtils utils = new StringUtils();

        String result = utils.coctacLowerCase("hello", null);
        assertThat(result).isEqualTo("hello");

        result = utils.coctacLowerCase(null, "hello");
        assertThat(result).isEqualTo("hello");
    }

    @Test
    public void oneEmptyString(){
        StringUtils utils = new StringUtils();

        String result = utils.coctacLowerCase("hello", "");
        assertThat(result).isEqualTo("hello");

        result = utils.coctacLowerCase("", "hello");
        assertThat(result).isEqualTo("hello");
    }


}