package ru.job4j.tracker;
/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 04.06.2019.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class StartUITest {
    /**
     * Добавить заявку.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }
    /**
     * Редактировать заявку.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    /**
     * Удалить заявку.
     */
    @Test
    public void whenTrackerDelete() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test name2", "desc2", 1234L));
        Input input = new StubInput(new String[]{"0", "test name1", "desc1", "0",
                "test name2", "desc2", "3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }/**
     * Показать все заявки.
     */
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    @Test
    public void whenTrackerShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Item item3 = tracker.add(new Item("test3", "desc3", 123L));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .append("------------ Наличие всех заявок --------------").append(System.lineSeparator())
                .append("------------ Имя пользователя : " + "test1" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc1" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append("---------------------------------------------------------------------------").
                        append(System.lineSeparator())
                .append("------------ Имя пользователя : " + "test2" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc2" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append("---------------------------------------------------------------------------").
                        append(System.lineSeparator())
                .append("------------ Имя пользователя : " + "test3" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc3" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append("---------------------------------------------------------------------------").
                        append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }
    /**
     * Поиск заявки по имени.
     */
    @Test
    public void whenTrackerFoundName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Item item3 = tracker.add(new Item("test3", "desc3", 123L));
        Input input = new StubInput(new String[]{"5", "test1", "6"});
        new StartUI(input, tracker).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .append("------------ Поиск по имени заявки --------------").append(System.lineSeparator())

                .append("------------ Имя пользователя : " + "test1" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc1" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append("---------------------------------------------------------------------------").
                        append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }
    /**
     * Поиск заявки по id.
     */
    @Test
    public void whenTrackerFoundId() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Item item3 = tracker.add(new Item("test3", "desc3", 123L));
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .append("------------ Поиск по номеру заявки --------------").append(System.lineSeparator())
                .append("------------ Имя пользователя : " + "test2" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc2" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }
}

