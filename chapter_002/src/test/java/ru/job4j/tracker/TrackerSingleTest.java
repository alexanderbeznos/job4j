package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 09.08.2019.
 */

public class TrackerSingleTest {
    /**
     * Test.
     */
    @Test
    public void whenTrackerSingle1() {
        TrackerSingle1 version1 = TrackerSingle1.getInstance();
        TrackerSingle1 version2 = TrackerSingle1.getInstance();
        assertThat(version1, is(version2));

    }
    /**
     * Test.
     */
    @Test
    public void whenTrackerSingle2() {
        TrackerSingle2 version1 = TrackerSingle2.getInstance();
        TrackerSingle2 version2 = TrackerSingle2.getInstance();
        assertThat(version1, is(version2));

    }
    /**
     * Test.
     */
    @Test
    public void whenTrackerSingle3() {
        TrackerSingle3 version1 = TrackerSingle3.getInstance();
        TrackerSingle3 version2 = TrackerSingle3.getInstance();
        assertThat(version1, is(version2));

    }
    /**
     * Test.
     */
    @Test
    public void whenTrackerSingle4() {
        TrackerSingle4 version1 = TrackerSingle4.getInstance();
        TrackerSingle4 version2 = TrackerSingle4.getInstance();
        assertThat(version1, is(version2));

    }
}
