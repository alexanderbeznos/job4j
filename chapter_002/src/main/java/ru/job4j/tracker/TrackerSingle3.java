package ru.job4j.tracker;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 09.08.2019.
 */

public class TrackerSingle3 {
    private TrackerSingle3() {
    }
    private static class Holder {
        private final static TrackerSingle3 instance = new TrackerSingle3();
    }
    public static TrackerSingle3 getInstance() {
        return Holder.instance;
    }
}
