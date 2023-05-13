package ru.igoregorov;

import ru.igoregorov.enums.KindException;
import ru.igoregorov.exceptions.IllegalConditions;

import static ru.igoregorov.utils.Utils.isZero;
import static ru.igoregorov.utils.Utils.toDouble;


public class HW0101PolynomQuadrato {

    public static<T> Double[] getSolve(T par_a, T par_b, T par_c) throws IllegalConditions {
        Double a = toDouble(par_a);
        Double b = toDouble(par_b);
        Double c = toDouble(par_c);

        boolean isZeroA = isZero(a);
        boolean isZeroB = isZero(b);
        if (isZeroA && isZeroB && isZero(c)) {
            throw new IllegalConditions(KindException.INFINIT_SOLUTION);
        }
        if (isZeroA && isZeroB) {
            throw new IllegalConditions(KindException.NO_SOLUTION);
        }
        if (isZeroA) {
            throw new IllegalConditions(KindException.NO_POLYNOM);
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
