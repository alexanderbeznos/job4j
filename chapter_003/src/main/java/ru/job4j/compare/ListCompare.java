package main.java.ru.job4j.compare;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] masleft = left.toCharArray();
        char[] masright = right.toCharArray();
        int a = 0;
        for (int i = 0;  i < (masleft.length < masright.length ? masleft.length : masright.length); i++) {
            if (Character.compare(masleft[i], masright[i]) != 0) {
                 a = Character.compare(masleft[i], masright[i]);
                 break;
            }
        }
        if (a == 0 && masleft.length < masright.length) {
            a = -1;
        }
        return a;
    }
}
