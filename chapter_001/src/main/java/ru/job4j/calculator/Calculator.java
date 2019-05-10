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
     *
     * @param first
     * @param second
     * @param third
     * @return
     */
    public double add(double first, double second, double third) {
        double tmp = add(second, third);
        return add(first, tmp);
    }
    /**
     *
     * @param first
     * @param second
     * @param third
     * @param fourth
     * @return
     */
    public double add(double first, double second, double third, double fourth) {
        double tmp = add(second, third, fourth);
        return add(first, tmp);
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
