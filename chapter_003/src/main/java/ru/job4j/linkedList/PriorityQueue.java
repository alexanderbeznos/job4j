package main.java.ru.job4j.linkedList;

import java.util.LinkedList;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.4.
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
        if (tasks.size() == 0) {
            tasks.add(task);
            return;
        }
        int i = 0;
        boolean a = false;
        for (Task o : tasks) {
            if (o.getPriority() >= task.getPriority()) {
                a = true;
                break;
            }
            i++;
        }
        if(a) {
            tasks.add(i, task);
        } else {
            tasks.add(task);
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
