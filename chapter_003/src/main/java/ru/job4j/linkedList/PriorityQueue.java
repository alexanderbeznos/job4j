package main.java.ru.job4j.linkedList;

import java.util.LinkedList;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.08.2019.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                tasks.add(i, task);
                return;
            }
        }
        tasks.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}