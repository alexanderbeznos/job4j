package ru.job4j.four;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
            Paint pe = new Paint();
            pe.draw(new Square());
    }
}