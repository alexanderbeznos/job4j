package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * Класс отвечает за движение нашей фигуры.
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 11.08.2019.
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Сначала проверяется, пожет ли выбранная фигура сделать желаемы код.
     * Если да, то на новой ячейке создаётся копия рассматриваемой фигуры.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException,
            FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException("В заданной ячейки нет фигуры");
        }
        Cell[] steps = this.figures[index].way(source, dest);
        if (steps.length < 1) {
            throw new ImpossibleMoveException("Фигура не может так двигаться");
        }
        for (Cell o : steps) {
            if (this.findBy(o) != -1) {
                throw new OccupiedWayException("Путь занят фигурами");
            }
        }
        if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Возвращает индекс фигуры из массива фигур .
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
