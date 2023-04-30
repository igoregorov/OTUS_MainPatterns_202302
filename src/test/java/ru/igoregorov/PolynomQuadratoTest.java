package ru.igoregorov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.igoregorov.exceptions.IllegalConditions;

import static org.junit.jupiter.api.Assertions.*;

class PolynomQuadratoTest {

    @Test
    void getSolve101() throws IllegalConditions {
        Double a = 0D;
        Double b = 0D;
        Double c = 0D;
        Assertions.assertArrayEquals(PolynomQuadrato.getSolve(a,b,c), new Double[]{});
    }
}