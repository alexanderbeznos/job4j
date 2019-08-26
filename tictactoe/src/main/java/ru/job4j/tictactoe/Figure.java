package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 24.08.2019.
 *
 * Отвечает за клетку на поле.
 * Он содержит методы - имеет ли клетка крестик или нолик. Или пустая.
 */
public class Figure extends Rectangle {
    private boolean markX = false;
    private boolean markO = false;

    public Figure() {
    }

    public Figure(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    public void take(boolean markX) {
            this.markX = markX;
            this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }
}
