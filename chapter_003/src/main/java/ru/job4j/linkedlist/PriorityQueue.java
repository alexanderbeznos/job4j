package ru.job4j.linkedlist;


import java.util.LinkedList;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.5.
 * @since 15.08.2019.
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int i = 0;
        for (Task o : tasks) {
            if (o.getPriority() >= task.getPriority()) {
                break;
            }
            i++;
        }
        tasks.add(i, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
