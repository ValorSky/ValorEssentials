package fr.kalipso.hexael.utils;

import java.util.Arrays;

public class StringUtils {

    public static String joinArray(String[] array, String delimiter, int start) {
        if(array.length < start) return "";

        return String.join(Color.translate(delimiter), Arrays.copyOfRange(array, start - 1, array.length));
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
