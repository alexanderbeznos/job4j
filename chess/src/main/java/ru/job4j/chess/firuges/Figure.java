package ru.job4j.chess.firuges;

public interface Figure {
    /**
     * Возвращает текущую клетку, которую занимает.
     */
    Cell position();

    /**
     * Проверяет, что фигура может так двигаться.
     */
    Cell[] way(Cell source, Cell dest);

    /**
     * Возвращает простое имя базового класса, указанное в исходном коде.
     * Возвращает пустую строку, если базовый класс является анонимным.
     */
    default String icon() {
        return String.format("%s.png", this.getClass().getSimpleName());
    }

    /**
     * Для перезаписи при дживежении.
     */
    Figure copy(Cell dest);
}
