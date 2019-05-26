package ru.job4j.tracker;

/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 26.05.2019.
 */

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    /**
     * Добавить заявку.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    /**
     * Добавляем заявку в трекер. Теперь в объект проинициализирован id.
     * Создаем новую заявку.
     * Проставляем старый id из previous, который был сгенерирован выше.
     * Обновляем заявку в трекере.
     * Проверяем, что заявка с таким id имеет новые имя test2.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * Удалить заявку.
     */
    @Test
    public void whenDeleteItemThenReturnNewItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 1235L);
        tracker.add(third);
        Item fourth = new Item("test4", "testDescription4", 1236L);
        tracker.add(fourth);
        Item fifth = new Item("test5", "testDescription5", 1237L);
        tracker.add(fifth);
        tracker.delete(third.getId());
        assertThat(tracker.findAll().length, is(4));
        Item[] res = tracker.findAll();
        Item[] expect = {first, second, fourth, fifth};
        assertThat(res, is(expect));
    }
    /**
     * Найти все заявки.
     */
    @Test
    public void whenFindAllItemThenAllItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 1235L);
        tracker.add(third);
        Item fourth = new Item("test4", "testDescription4", 1236L);
        tracker.add(fourth);
        Item fifth = new Item("test5", "testDescription5", 1237L);
        tracker.add(fifth);
        Item[] res = tracker.findAll();
        Item[] expect = {first, second, third, fourth, fifth};
        assertThat(res, is(expect));
    }
    /**
     * Найти по имени.
     */
    @Test
    public void whenFindByNameThenReturnNewItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 1235L);
        tracker.add(third);
        Item fourth = new Item("test4", "testDescription4", 1236L);
        tracker.add(fourth);
        Item fifth = new Item("test5", "testDescription5", 1237L);
        tracker.add(fifth);
        Item[] res = tracker.findByName("test2");
        Item[] expect = {second};
        assertThat(res, is(expect));
    }
    /**
     * Найти по id.
     */
    @Test
    public void whenFindByIdThenReturnNewItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1234L);
        tracker.add(second);
        Item third = new Item("test3", "testDescription3", 1235L);
        tracker.add(third);
        Item fourth = new Item("test4", "testDescription4", 1236L);
        tracker.add(fourth);
        Item fifth = new Item("test5", "testDescription5", 1237L);
        tracker.add(fifth);
        Item res = tracker.findById(third.getId());
        assertThat(res, is(third));
    }
}


