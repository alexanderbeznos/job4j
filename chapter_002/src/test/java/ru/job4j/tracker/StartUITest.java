package ru.job4j.tracker;
/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 04.06.2019.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    private final String menu = this.menus();
    private String menus() {
        StringBuilder screen = new StringBuilder();
        screen.append("0. Add new Item").append(System.lineSeparator());
        screen.append("1. Show all items").append(System.lineSeparator());
        screen.append("2. Edit item").append(System.lineSeparator());
        screen.append("3. Delete item").append(System.lineSeparator());
        screen.append("4. Find item by Id").append(System.lineSeparator());
        screen.append("5. Find items by name").append(System.lineSeparator());
        screen.append("6. Exit Program").append(System.lineSeparator());
        return screen.toString();
    }
    /**
     * Добавить заявку.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(Arrays.asList("0", "test name", "desc", "6"));
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }
    /**
     * Редактировать заявку.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(Arrays.asList("2", item.getId(), "test replace", "заменили заявку", "6"));
        new StartUI(input, tracker, output).init();
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
        Input input = new StubInput(Arrays.asList("0", "test name1", "desc1", "0",
                "test name2", "desc2", "3", item1.getId(), "6"));
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name2"));
    }

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Показать все заявки.
     */
    @Test
    public void whenTrackerShowItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Item item3 = tracker.add(new Item("test3", "desc3", 123L));
        Input input = new StubInput(Arrays.asList("1", "6"));
        new StartUI(input, tracker, output).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append(menu)
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
                .append(menu).append("Выбран пункт меню 6. Выход из программы. До свидания!").
                        append(System.lineSeparator())
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
        Input input = new StubInput(Arrays.asList("5", item1.getId(), "6"));
        new StartUI(input, tracker, output).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append(menu)
                .append("------------ Поиск по имени заявки --------------").append(System.lineSeparator())
                .append("------------ Имя пользователя : " + "test1" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc1" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append("---------------------------------------------------------------------------").
                        append(System.lineSeparator())
                .append(menu).append("Выбран пункт меню 6. Выход из программы. До свидания!").
                        append(System.lineSeparator())
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
        Input input = new StubInput(Arrays.asList("4", item2.getId(), "6"));
        new StartUI(input, tracker, output).init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append(menu)
                .append("------------ Поиск по номеру заявки --------------").append(System.lineSeparator())
                .append("------------ Имя пользователя : " + "test2" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Описание заявки : " + "desc2" + "-----------").
                        append(System.lineSeparator())
                .append("------------ Время создания заявки : " + 123L + "-----------").
                        append(System.lineSeparator())
                .append(menu).append("Выбран пункт меню 6. Выход из программы. До свидания!").
                        append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }
}
