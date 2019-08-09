package ru.job4j.tracker;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 09.08.2019.
 */

public class TrackerSingle4 {
    private static  TrackerSingle4 instance;
    private TrackerSingle4() {
    }
    public static synchronized TrackerSingle4 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle4();
        }
        return instance;
    }

}
