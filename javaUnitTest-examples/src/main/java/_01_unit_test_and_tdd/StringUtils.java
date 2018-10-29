package _01_unit_test_and_tdd;

public class StringUtils {

    public String coctacLowerCase(String str1, String str2){
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
