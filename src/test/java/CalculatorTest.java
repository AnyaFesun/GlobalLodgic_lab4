import org.example.Calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals("579", Calculator.calculate("1 2 3 + 4 5 6 ="));
    }

    @Test
    void testSubtraction() {
        assertEquals("100", Calculator.calculate("1 2 3 - 2 3 ="));
    }

    @Test
    void testSubtractionLargerNumber() {
        assertEquals("-90", Calculator.calculate("1 0 - 1 0 0 ="));
    }

    @Test
    void testMultiplication() {
        assertEquals("220", Calculator.calculate("1 0 * 2 2 ="));
    }

    @Test
    void testDivision() {
        assertEquals("33", Calculator.calculate("1 0 0 / 3 ="));
    }

    @Test
    void testDivisionDivisorLarger() {
        assertEquals("0", Calculator.calculate("9 / 1 0 ="));
    }

    @Test
    void testDivisionByZero() {
        assertEquals("Помилка: арифметична помилка - Ділення на нуль!", Calculator.calculate("1 0 / 0 ="));
    }

    @Test
    void testEmptyInput() {
        assertEquals("0", Calculator.calculate(""));
    }

    @Test
    void testOneDigitPressed() {
        assertEquals("5", Calculator.calculate("5"));
    }

    @Test
    void testMultipleDigitsPressed() {
        assertEquals("123", Calculator.calculate("1 2 3"));
    }

    @Test
    void testFirstOperandPlusOperation() {
        assertEquals("245", Calculator.calculate("2 4 5 +"));
    }

    @Test
    void testNotPressedEquals() {
        assertEquals("4", Calculator.calculate("1 2 3 + 4"));
    }

    @Test
    void testFirstOperandOperationPlusEquals () {
        assertEquals("123", Calculator.calculate("1 2 3 + ="));
    }

    @Test
    void testOneOperandEqualsPressed () {
        assertEquals("123", Calculator.calculate("1 2 3 ="));
    }

    @Test
    void testMultipleSpaces() {
        assertEquals("579", Calculator.calculate("1   2   3   +  4 5  6 ="));
    }

    @Test
    void testInvalidCharacter() {
        assertEquals("Помилка: некоректна клавіша \"a\"", Calculator.calculate("1 0 a 0 ="));
    }

    @Test
    void testMixedSpacesAndInvalidCharacters() {
        assertEquals("Помилка: некоректна клавіша \"b\"", Calculator.calculate("1 2 3 +   b 4 5 ="));
    }

    @Test
    void testInputNotSeparatedBySpaces() {
        assertEquals("Помилка: некоректна клавіша \"123+5\"", Calculator.calculate("123+5 ="));
    }

    @Test
    void testMultipleArithmeticOperations () {
        assertEquals("Помилка: Ввід має містити лише одну арифметичну операцію", Calculator.calculate("1 2 3 + 3 + 4 ="));
    }
}
