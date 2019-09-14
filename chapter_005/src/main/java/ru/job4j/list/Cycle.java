package ru.job4j.list;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 14.09.2019.
 */
public class Cycle {
    public static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    boolean hasCycle(Node first) {
        if (first == null) {
            return false;
        }
        Node turtle = first;
        Node hare = first;
        while (hare.next != null && hare.next.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;

            if (turtle == hare) {
                return true;
            }
        }
        return false;

    }
}
