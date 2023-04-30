package ru.igoregorov;

import org.junit.jupiter.api.Test;
import ru.igoregorov.exceptions.IllegalConditions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class PolynomQuadratoTest extends DictionaryDatas {

    @Test
    void getSolve101() throws IllegalConditions {
        a = 1D;
        b = 0D;
        c = 1D;
        assertArrayEquals(new Double[]{}, PolynomQuadrato.getSolve(a, b, c));
    }
}