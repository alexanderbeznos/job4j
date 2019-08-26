package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic {
    private final Figure[][] table;

    public Logic(Figure[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     проверяет есть ли в поле выигрышные комбинации для Крестика.
     */
    public boolean isWinnerX() {
        return this.fillBy(Figure::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 2, 1, 0)
                || this.fillBy(Figure::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 2, 0, 0, 1)
                || this.fillBy(Figure::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure::hasMarkX, this.table.length - 1, 0, -1, 1);
    }

    /**
     *
     проверяет есть ли в поле выигрышные комбинации для Нолика.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 2, 1, 0)
                || this.fillBy(Figure::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 2, 0, 0, 1)
                || this.fillBy(Figure::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     проверяет, если ли пустые клетки для новых ходов.
     */
    public boolean hasGap() {
        boolean res = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (!table[i][j].hasMarkX() && !table[i][j].hasMarkO()) {
                    res = true;
                }
            }
        }
        return res;
    }
}
