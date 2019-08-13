package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 13.08.2019.
 */
public class QeenWhite implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if((Math.abs(dest.y - source.y) == Math.abs(dest.x - source.x))) {
            int size = Math.abs(source.x - dest.x);
            steps = new Cell[size];
            for (int i = 0; i < size; i++) {
                int x = (source.x < dest.x) ? source.x + i + 1 : source.x - i - 1;
                int y = (source.y < dest.y) ? source.y + i + 1 : source.y - i - 1;
                steps[i] = Cell.findXandY(x, y);
            }
        } else if (Math.abs(dest.y - source.y) == 0 || Math.abs(dest.x - source.x) == 0) {
            int size = Math.abs(dest.y - source.y) + Math.abs(dest.x - source.x);
            steps = new Cell[size];
            if (Math.abs(dest.y - source.y) == 0) {
                for (int i = 0; i < size; i++) {
                    int x = (source.x < dest.x) ? source.x + i + 1 : source.x - i - 1;
                    steps[i] = Cell.findXandY(x, source.y);
                }
            } else if (Math.abs(dest.x - source.x) == 0) {
                for (int i = 0; i < size; i++) {
                    int y = (source.y < dest.y) ? source.y + i + 1 : source.y - i - 1;
                    steps[i] = Cell.findXandY(source.x, y);
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
