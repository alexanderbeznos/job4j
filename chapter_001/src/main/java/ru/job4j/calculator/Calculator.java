package ru.job4j.calculator;

/**
 * Calculator.
 * @author Alexander Beznos (ast1bn@mail.ru)
 */
public class Calculator {
    /**
     *add.
     *@param first - первый параметр.
     *@param second - второй параметр.
     */
    public double add(double first, double second) {
        return first + second;
    }
    /**
     *subtract.
     *@param first - первый параметр.
     *@param second - второй параметр.
     */
    public double subtract(double first, double second) {
        return first - second;
    }
    /**
     *multiply.
     *@param first - первый параметр.
     *@param second - второй параметр.
     */
    public double multiply(double first, double second) {
        return first * second;
    }
    /**
     *div.
     *@param first - первый параметр.
     *@param second - второй параметр.
     */
    public double div(double first, double second) {
        return first / second;
    }
}
