package ru.job4j;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 13.08.2019.
 */
public class CoffeeMachine {
    private static int one = 1;
    private static int two = 2;
    private static int five = 5;
    private static int ten = 10;

    /**
     * Метод реализаущий выдачн сдачи автомата.
     * @param value купюра.
     * @param price цена кофе.
     */
    int[] changes(int value, int price) {
        int[] change = new int[100];
        int count = 0;
        int valueS = value - price;
        for (int i = 0; valueS != 0; i++) {
            if (valueS >= ten) {
                valueS = valueS - ten;
                change[i] = ten;
                count++;
            } else if (valueS >= five) {
                valueS = valueS - five;
                change[i] = five;
                count++;
            } else if (valueS >= two) {
                valueS = valueS - two;
                change[i] = two;
                count++;
            } else if (valueS >= one) {
                valueS = valueS - one;
                change[i] = one;
                count++;
            }
        }
        int[] changeMain = new int[count];
        for (int i = 0; i < count; i++) {
            changeMain[i] = change[i];
        }
        return changeMain;
    }
}
