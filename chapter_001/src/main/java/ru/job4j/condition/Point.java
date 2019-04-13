package ru.job4j.condition;

/**
 * Расстояния между точками в системе координат.
 */
public class Point {
/**
 * Нахождение расстояния.
 * @param x1 координата.
 * @param x2 координата.
 * @param y1 координата.
 * @param y2 координата.
 * @return distance.
 */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        double three = second - first;
        return Math.pow(three, 0.5);
    }
}
