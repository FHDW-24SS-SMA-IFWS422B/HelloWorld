package test;

import src.calculator.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestCalculator {

    @Test
    void testSimpleAddition() throws Exception {
        Calculator calc = new Calculator();

        String result = calc.eval("3+5");
        assertEquals("8.0", result);
        result = calc.eval("5+0");
        assertEquals("5.0", result);
        result = calc.eval("-3+5");
        assertEquals("2.0", result);
    }

    @Test
    void testSimpleSubtraction() throws Exception {
        Calculator calc = new Calculator();

        String result = calc.eval("5-3");
        assertEquals("2.0", result);
        result = calc.eval("5-0");
        assertEquals("5.0", result);
        result = calc.eval("0-7");
        assertEquals("-7.0", result);
        result = calc.eval("7--3");
        assertEquals("10.0", result);
    }

    @Test
    void testSimpleMultiplication() throws Exception {
        Calculator calc = new Calculator();

        String result = calc.eval("3*5");
        assertEquals("15.0", result);
        result = calc.eval("3*0");
        assertEquals("0.0", result);
        result = calc.eval("-5*5");
        assertEquals("-25.0", result);
    }

    @Test
    void testSimpleDivision() throws Exception {
        Calculator calc = new Calculator();

        String result = calc.eval("15/3");
        assertEquals("5.0", result);

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.eval("5/0");
        });
        assertEquals("Division by zero", exception.getMessage());

        result = calc.eval("10/3");
        assertEquals("3.3333333333333335", result);
    }
}
