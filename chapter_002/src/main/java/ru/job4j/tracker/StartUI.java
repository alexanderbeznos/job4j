package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.3.
 * @since 09.08.2019.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Флажок для выхода.
     * Программа работает до тех пор, пока значение истинно.
     */
    private boolean working = true;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (this.working);
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
    public  void stop() {
        this.working = false;
    }
}
