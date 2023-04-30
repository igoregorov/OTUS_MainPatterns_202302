package ru.igoregorov;

import ru.igoregorov.exceptions.IllegalConditions;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalConditions {
        try {
            Double[] solution = PolynomQuadrato.getSolve(0D, -5D, 2D);
            String solutionCount = null;
            switch (solution.length) {
                case 0:
                    solutionCount = "Решений ни одного ";
                    break;
                case 1:
                    solutionCount = "Решение одно: ";
                    break;
                case 2:
                    solutionCount = "Решений два: ";
                    break;
                default:
                    break;
            }
            System.out.println(solutionCount + Arrays.toString(solution));
        } catch (IllegalConditions e) {
            System.out.println(e.getMessage());
        }
    }
}