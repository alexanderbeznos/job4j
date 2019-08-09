package ru.job4j.tracker;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 09.08.2019.
 */

public class TrackerSingle2 {
    private static TrackerSingle2 instance = new TrackerSingle2();
    private  TrackerSingle2() {
    }
    public static TrackerSingle2 getInstance() {
        return instance;
    }
}
