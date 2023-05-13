package ru.igoregorov;

import org.junit.jupiter.api.Test;
import ru.igoregorov.enums.KindException;
import ru.igoregorov.exceptions.IllegalConditions;

import static org.junit.jupiter.api.Assertions.*;


class HW0101PolynomQuadratoTest extends DictionaryDatas {

    @Test
    void getSolveEmpty() {
        a = 1D;
        b = 0D;
        c = 1D;
        try {
            assertArrayEquals(new Double[]{}, HW0101PolynomQuadrato.getSolve(a, b, c));
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    void getSolveTwo() {
        a = 1D;
        b = 0D;
        c = -1D;
        sol = new Double[]{-1D, 1D};
        try {
            assertArrayEquals(sol, HW0101PolynomQuadrato.getSolve(a, b, c));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getSolveOne() {
        a = 1D;
        b = 2D;
        c = 1D;
        sol = new Double[]{-1D};
        try {
            assertArrayEquals(sol, HW0101PolynomQuadrato.getSolve(a, b, c));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getSolveAzero() {
        a = 0D;
        b = 2D;
        c = 1D;
        IllegalConditions exception = assertThrows(IllegalConditions.class,
                () -> HW0101PolynomQuadrato.getSolve(a, b, c));
        assertEquals(KindException.NO_POLYNOM.getDescription(), exception.getMessage());
    }

    @Test
    void getSolveDzero() {
        a = 1D;
        b = 2e-4;
        c = 1e-9;
        sol = new Double[]{-1e-4};
        try {
            assertArrayEquals(sol, HW0101PolynomQuadrato.getSolve(a, b, c));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void getSolveNonNumber() {
        a = 1D;
        b = 2e-4;
        c = 1e-9;
        anyThing = "a";
        sol = new Double[]{-1e-4};
        IllegalConditions exception = assertThrows(IllegalConditions.class,
                () -> HW0101PolynomQuadrato.getSolve(anyThing, b, c));
        assertEquals(KindException.NO_NUMBER_COEF.getDescription(), exception.getMessage());
    }
}