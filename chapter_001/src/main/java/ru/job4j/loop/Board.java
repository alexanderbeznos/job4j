package ru.job4j.loop;

/**
 * Постройка шахматной доски.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 21.04.2019.
 */
public class Board {
    /**
     *
     * @param width ширина.
     * @param height высота.
     * @return вывод.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
            } else {
                screen.append(" ");
            }
        }
        screen.append(ln);
    }
        return screen.toString();
}
}