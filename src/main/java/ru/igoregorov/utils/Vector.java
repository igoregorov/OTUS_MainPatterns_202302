package ru.igoregorov.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Vector {
    List<Integer> elements;

    public Vector(Integer ... el) {
        elements = new ArrayList<>();
        elements.addAll(Arrays.asList(el));
    }
    public Vector (List<Integer> elems) {
        elements = new ArrayList<>();
        elements = List.copyOf(elems);
    }

    private Object get(int i) {
        return elements.get(i);
    }

    public Vector plus(Vector newVector) {
        int size = elements.size();
        Vector resultVector = new Vector(0, 0);
        for (int i=0; i < size; i++) {
            try {
                Integer el = castInteger(this.elements.get(i));
                el += castInteger(newVector.get(i));
                resultVector.elements.set(i, el);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return resultVector;
    }

    public Vector minus(Vector newVector) {
        int size = elements.size();
        for (int i=0; i < size; i++) {
            try {
                Integer el = castInteger(this.elements.get(i));
                el -= castInteger(newVector.get(i));
                elements.set(i, el);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return new Vector(elements);
    }

    public Double getLength() {
        try {
            Long a = Long.valueOf(this.elements.get(0));
            Long b = Long.valueOf(this.elements.get(1));
            return Math.sqrt(a * a + b * b);
        } catch (ArithmeticException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int i = 1;
        for (Object obj : elements) {
            stringBuilder.append(obj);
            if (i++ != elements.size()) stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static Double castDouble(Object obj) {
        return Double.valueOf(String.valueOf(obj));
    }
    public static Integer castInteger(Object obj) {
        return Integer.valueOf(String.valueOf(obj));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!obj.getClass().equals(Vector.class)) return false;

        return Objects.equals(this.elements.get(0), ((Vector) obj).elements.get(0)) &&
                Objects.equals(this.elements.get(1), ((Vector) obj).elements.get(1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
