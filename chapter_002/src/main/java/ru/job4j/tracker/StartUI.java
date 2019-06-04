package ru.job4j.tracker;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 04.06.2019.
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String REPLACE = "2";
    private static final String DELETE = "3";
    private static final String ID = "4";
    private static final String NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItem();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (ID.equals(answer)) {
                this.findByIdItem();
            } else if (NAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long time = System.currentTimeMillis();
        Item item = new Item(name, desc, time);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с номером : " + item.getId() + "-----------");
    }
    /**
     * Метод реализует выдачу всех заявок.
     */
    private void showItem() {
        System.out.println("------------ Наличие всех заявок --------------");
        Item[] result = this.tracker.findAll();
        for (int i = 0; i != result.length; i++) {
            System.out.println("------------ Имя пользователя : " + result[i].getName() + "-----------");
            System.out.println("------------ Описание заявки : " + result[i].getDecs() + "-----------");
            System.out.println("------------ Время создания заявки : " + result[i].getTime() + "-----------");
            System.out.println("---------------------------------------------------------------------------");
        }
    }
    /**
     * Метод реализует редактирование заявки.
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите номер заявки :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long time = System.currentTimeMillis();
        Item item = new Item(name, desc, time);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------" + "Выполнено" + "-----------");
        } else {
            System.out.println("------------" + "Не выполнено" + "-----------");
        }
    }
    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите номер заявки :");
        if (this.tracker.delete(id)) {
            System.out.println("------------" + "Выполнено" + "-----------");
        } else {
            System.out.println("------------" + "Не выполнено" + "-----------");
        }
    }
    /**
     * Метод реализует нахождение заявки по номеру.
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск по номеру заявки --------------");
        String id = this.input.ask("Введите номер заявки :");
        Item result = this.tracker.findById(id);
        if (result != null) {
            System.out.println("------------ Имя пользователя : " + result.getName() + "-----------");
            System.out.println("------------ Описание заявки : " + result.getDecs() + "-----------");
            System.out.println("------------ Время создания заявки : " + result.getTime() + "-----------");
        }
    }
    /**
     * Метод реализует нахождение заявки по имени.
     */
    private void findByNameItem() {
        System.out.println("------------ Поиск по имени заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] result = this.tracker.findByName(name);
        for (int i = 0; i != result.length; i++) {
            System.out.println("------------ Имя пользователя : " + result[i].getName() + "-----------");
            System.out.println("------------ Описание заявки : " + result[i].getDecs() + "-----------");
            System.out.println("------------ Время создания заявки : " + result[i].getTime() + "-----------");
            System.out.println("---------------------------------------------------------------------------");
        }
    }
    /**
     * Метод реализует появление
     */
    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
