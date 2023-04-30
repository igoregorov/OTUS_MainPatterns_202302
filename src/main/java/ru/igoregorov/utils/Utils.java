package ru.igoregorov.utils;

public class Utils {

    private static final double EPSILON = 1e-7;

    public static Double toDouble(Double obj) {
        return obj == null ? 0D : obj;
    }
    public static <T> boolean isZero(T obj) {
        if (obj == null) return true;
        return obj.equals(0D) || isEpsilon(obj);
    }

    private static<T> boolean isEpsilon(T obj) {
        try {
            Double d = (Double) obj;
            return Math.abs(d) < EPSILON;
        } catch (Exception e) {
            return false;
        }
    }
}
