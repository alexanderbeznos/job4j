package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 09.06.2019.
 */
public class MenuTracker {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int REPLACE = 2;
    private static final int DELETE = 3;
    private static final int ID = 4;
    private static final int NAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final int EXIT = 6;
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(ADD, "Add new Item"));
        this.actions.add(new ShowItems(SHOW, "Show all items"));
        this.actions.add(new UpdateItem(REPLACE, "Edit item"));
        this.actions.add(new DeleteItem(DELETE, "Delete item"));
        this.actions.add(new FindItemById(ID, "Find item by Id"));
        this.actions.add(new FindItemsByName(NAME, "Find items by name"));
        this.actions.add(new ExitProgram(EXIT, "Exit Program", ui));
    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long time = System.currentTimeMillis();
            Item item = new Item(name, desc, time);
            tracker.add(item);
            System.out.println("------------ Новая заявка с номером : " + item.getId());
            System.out.println("------------ Новая завка с именем : " + item.getName());
            System.out.println("------------ Новая заявка с описанием : " + item.getDecs());
        }
    }
    public class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Наличие всех заявок --------------");
            List<Item> result = tracker.findAll();
            for (int i = 0; i != result.size(); i++) {
                System.out.println("------------ Имя пользователя : " + result.get(i).getName() + "-----------");
                System.out.println("------------ Описание заявки : " + result.get(i).getDecs() + "-----------");
                System.out.println("------------ Время создания заявки : " + result.get(i).getTime() + "-----------");
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }
    public class UpdateItem extends BaseAction {
        public UpdateItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите номер заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long time = System.currentTimeMillis();
            Item item = new Item(name, desc, time);
            if (tracker.replace(id, item)) {
                System.out.println("------------" + "Выполнено" + "-----------");
            } else {
                System.out.println("------------" + "Не выполнено" + "-----------");
            }
        }
    }
    public class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите номер заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------" + "Выполнено" + "-----------");
            } else {
                System.out.println("------------" + "Не выполнено" + "-----------");
            }
        }
    }
    public class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск по номеру заявки --------------");
            String id = input.ask("Введите номер заявки :");
            Item result = tracker.findById(id);
            if (result != null) {
                System.out.println("------------ Имя пользователя : " + result.getName() + "-----------");
                System.out.println("------------ Описание заявки : " + result.getDecs() + "-----------");
                System.out.println("------------ Время создания заявки : " + result.getTime() + "-----------");
            }
        }
    }
    public class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск по имени заявки --------------");
            String id = input.ask("Введите номер заявки :");
            Item result = tracker.findById(id);
            if (result != null) {
                System.out.println("------------ Имя пользователя : " + result.getName() + "-----------");
                System.out.println("------------ Описание заявки : " + result.getDecs() + "-----------");
                System.out.println("------------ Время создания заявки : " + result.getTime() + "-----------");
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }
    public class ExitProgram extends BaseAction {
        private final StartUI ui;
        public ExitProgram(int key, String name, StartUI ui) {
            super(key, name);
            this.ui = ui;

        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выбран пункт меню 6. Выход из программы. До свидания!");
            this.ui.stop();
        }
    }
}