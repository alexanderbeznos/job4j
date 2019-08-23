package ru.job4j.depart;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 21.08.2019.
 */
public class Department {

    /**
     * метод добавляет верхние подразделнений и сортирует по возростанию.
     */
    public Set<String> structure(List<String> list) {
        Set<String> res = new TreeSet<>(list);
        for (String pos : list) {
            List<String> help = Arrays.asList(pos.split("\\\\"));
            for (int i = help.size() - 1; i >= 1; i--) {
                List<String> now = help.subList(0, i);
                String joined = String.join("\\", now);
                res.add(joined);
            }
        }
        return res;
    }

    /**
     * метод сортирует по убыванию.хз
     */
    public List<String> sortlow(List<String> list) {
        ArrayList<String> resul = new ArrayList<>();
        ArrayList<String> step;
        TreeSet<String> tree = setmake(list);
        for (String o : tree) {
            step = allset(o, list);
            resul.addAll(step);
        }
        return resul;
    }

    /**
     * метод возвращает список всех главных подразделений отсортированный по убыванию(“K2”, “K1”).
     */
    public TreeSet<String> setmake(List<String> list) {
        TreeSet<String> li = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for (String s : list) {
            Pattern p = Pattern.compile("^[a-zA-Z]*[0-9]*");
            Matcher m = p.matcher(s);
            while (m.find()) {
                li.add(m.group());
            }

        }
        return li;
    }

    /**
     * Метод возвращает лист всех отделов относящихся к одному подразделения. Отсортированы по требованию задачи.
     */
    public ArrayList<String> allset(String tree, List<String> list) {
        ArrayList<String> res = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith(tree)) {
                res.add(s);
            }
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o2.compareTo(o1) : Integer.compare(o1.length(), o2.length());
            }
        });
        return res;
    }
}
