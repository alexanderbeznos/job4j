package ru.job4j.array;
/**
 * Квадратный массив true или false .
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 30.04.2019.
 */
public class MatrixCheck {
    /**
     * вычисление true или false.
     * @param date массив.
     * @return true или false
     */
    public boolean mono(boolean[][] date) {
        boolean result = true;
       for (int i = 0; i != date.length; i++) {
           if (date[0][0] != date[i][i] || date[0][date[0].length - 1] != date[i][(date[i].length - 1) - i]) {
                   result = false;
                   break;
           }
       }
       return result;
    }

}


