package ru.igoregorov;

import ru.igoregorov.exceptions.IllegalConditions;

import static ru.igoregorov.utils.Utils.isZero;
import static ru.igoregorov.utils.Utils.toDouble;


public class PolynomQuadrato {

    public static Double[] getSolve(Double a, Double b, Double c) throws IllegalConditions {
        a = toDouble(a);
        b = toDouble(b);
        c = toDouble(c);

        boolean isZeroA = isZero(a);
        boolean isZeroB = isZero(b);
        if (isZeroA && isZeroB && isZero(c)) {
            throw new IllegalConditions(IllegalConditions.Kind.INFINIT_SOLUTION);
        }
        if (isZeroA && isZeroB) {
            throw new IllegalConditions(IllegalConditions.Kind.NO_SOLUTION);
        }
        if (isZeroA) {
            throw new IllegalConditions(IllegalConditions.Kind.NO_POLYNOM);
        }

        double d = (b*b - 4*a*c);
        if (d < 0) {
            return new Double[]{};
        }

        if (isZero(d)) {
            return new Double[]{-b/(2*a)};
        }

        Double[] solution = new Double[2];
        solution[0] = ((-b - Math.sqrt(d)) / (2*a));
        solution[1] = ((-b + Math.sqrt(d)) / (2*a));
        return solution;

    }

}
