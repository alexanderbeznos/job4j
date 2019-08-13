package ru.job4j;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 13.08.2019.
 */
public class CoffeeMachine {

    /**
     * Метод реализаущий выдачн сдачи автомата.
     * @param value купюра.
     * @param price цена кофе.
     */
    int[] changes(int value, int price) {
        int[] money = new int[] {10, 5, 2,1};
        int[] change = new int[4];
        int valueS = value - price;
        while (valueS != 0) {
            if (valueS >= money[0]) {
                valueS = valueS - money[0];
                change[0]++;
            } else if (valueS >= money[1]) {
                valueS = valueS - money[1];
                change[1]++;
            } else if (valueS >= money[2]) {
                valueS = valueS - money[2];
                change[2]++;
            } else if (valueS >= money[3]) {
                valueS = valueS - money[3];
                change[3]++;
            }
        }
        int count = change[0] + change[1] + change[2] + change[3];
        int[] changeMain = new int[count];
        int numb = 0;
        for (int i = 0; i < change.length; i++) {
            while (change[i] != 0) {
                changeMain[numb] = money[i];
                change[i]--;
                numb++;
                if (numb > count) {
                    break;
                }
            }

        }
        return changeMain;
    }
}
