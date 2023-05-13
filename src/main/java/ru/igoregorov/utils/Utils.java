package ru.igoregorov.utils;

import ru.igoregorov.enums.KindException;
import ru.igoregorov.exceptions.IllegalConditions;

public class Utils {

    private static final double EPSILON = 1e-7;

    public static<T> Double toDouble(T obj) throws IllegalConditions {
        if (obj == null) return 0D;
        try {
            return Double.valueOf(obj.toString());
        } catch (NumberFormatException e) {
            throw new IllegalConditions(KindException.NO_NUMBER_COEF);
        }
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

    public static<T> T nvl(T obj, T def)  {
        if (obj == null) return def;
        return obj;
    }
}
