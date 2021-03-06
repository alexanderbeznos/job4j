package ru.job4j.condition;

/**
 * Вычисление площади треугольника.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 09.05.2019.
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;
    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    /**
     * Метод вычисления периметра по длинам сторон.
     * @param a расстояние между точками a b.
     * @param b расстояние между точками a c.
     * @param c расстояние между точками b c.
     * @return Перимент.
     */
    public double period(double a, double b, double c) {
        double result = (a + b + c) / 2;
        return result;
    }
    /**
     * Метод должен вычислить прощадь треугольканива.
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * @param a Длина от точки a b.
     * @param b Длина от точки a c.
     * @param c Длина от точки b c.
     * @return false.
     */
    private boolean exist(double a, double c, double b) {
        return (a + b > c && b + c > a && a + c > b);
    }
}