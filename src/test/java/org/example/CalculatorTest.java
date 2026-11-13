
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() throws InvalidInputException {
        assertEquals(15, calculator.add(10, 5), 0.001);
    }

    @Test
    public void testSubtraction() throws InvalidInputException {
        assertEquals(5, calculator.subtract(10, 5), 0.001);
    }

    @Test
    public void testMultiplication() throws InvalidInputException {
        assertEquals(50, calculator.multiply(10, 5), 0.001);
    }

    @Test
    public void testDivision() throws InvalidInputException {
        assertEquals(2, calculator.divide(10, 5), 0.001);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }

    @Test
    public void testInvalidStringInput() {
        assertThrows(
                InvalidInputException.class,
                () -> Main.parseNumber("abc")
        );
    }

    @Test
    public void testSquareRoot() throws InvalidInputException {
        assertEquals(4, calculator.sqrt(16), 0.001);
    }

    @Test
    public void testNegativeSquareRoot() {
        assertThrows(
                InvalidInputException.class,
                () -> calculator.sqrt(-9)
        );
    }

    @Test
    public void testInvalidInputNaN() {
        assertThrows(
                InvalidInputException.class,
                () -> calculator.add(Double.NaN, 5)
        );
    }

    @Test
    public void testInvalidInputInfinity() {
        assertThrows(
                InvalidInputException.class,
                () -> calculator.multiply(Double.POSITIVE_INFINITY, 2)
        );
    }

    @Test
    public void testNegativeNumbers() throws InvalidInputException {
        assertEquals(-5, calculator.add(-10, 5), 0.001);
    }

    @Test
    public void testOverflow() {
        assertThrows(
                InvalidInputException.class,
                () -> calculator.multiply(Double.MAX_VALUE, 2)
        );
    }

    @Test
    public void testCommaDecimalInput()
            throws InvalidInputException {

        assertEquals(2.5, Main.parseNumber("2,5"), 0.001);
    }
}
