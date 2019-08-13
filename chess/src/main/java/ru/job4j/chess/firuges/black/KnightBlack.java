package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 13.08.2019.
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if((Math.abs(dest.y - source.y) == 2 && Math.abs(dest.x - source.x) == 1) ||
                (Math.abs(dest.y - source.y) == 1 && Math.abs(dest.x - source.x) == 2)) {
            int size = Math.abs(dest.y - source.y) - Math.abs(dest.x - source.x);
            steps = new Cell[] { dest };


        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }
}
