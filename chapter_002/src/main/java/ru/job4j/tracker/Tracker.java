package ru.job4j.tracker;

import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.2.
 * @since 27.05.2019.
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод реализующий замену заявки.
     * Пройтись по всем элементам массива. После нахождения заявки с совпадающим id, заменить новую item на старую.
     * Также присваиваем новой заявке id.
     * @param id заявки, которую нужно заменить.
     * @param item входящая заявка, параметры которой надо записать вместо старой.
     * @return возврат.
     */
    public boolean replace(String id, Item item) {
        boolean repl = false;
        for (int i = 0; i != items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                items[i].setId(id);
                repl = true;
                break;
            }
        }
        return repl;
    }
    /**
     * Метод реализующий удаление заявки.
     * @param id удаляемой заявки.
     * @return возврат.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i != this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, position - i);
                items[position - 1] = null;
                position--;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Метод позволяющий найти все заявки.
     * @return возврат.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Метод позволябщий найти заявки по имени.
     * @param key передавать в метод.
     * @return возврат.
     */
    public Item[] findByName(String key) {
        Item[] step = new Item[100];
        int poz = 0;
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                step[poz++] = items[i];
            }
        }
        return Arrays.copyOf(step, poz);
    }
    /**
     * Метод позволябщий найти заявки по id.
     * @param id передавать в метод.
     * @return возврат.
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}

