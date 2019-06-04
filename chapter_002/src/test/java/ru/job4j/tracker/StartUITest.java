package ru.job4j.tracker;
/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 04.06.2019.
 */
import org.junit.Test;
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
    }
}
