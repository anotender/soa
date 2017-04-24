package pl.edu.agh.soa.lab2.zad5.utils;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

}
