package ru.job4j.tracker;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 09.08.2019.
 */

public class TrackerSingle1 {
    private static TrackerSingle1 instance;
    private TrackerSingle1() {
    }
    public static TrackerSingle1 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle1();
        }
        return instance;
    }


}
