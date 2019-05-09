package ru.job4j.condition;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
/**
 * Расстояния между точками в системе координат.
 */
public class Point {
/**
 * Нахождение расстояния.
 * @param first координата.
 * @param second координата.
 * @return distance.
 */
    private int x;
    private int y;
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }
    public double distance(Point that) {
        return sqrt(pow(this.x - that.x, 2) + pow(this.y - that.y, 2));
    }
    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}
