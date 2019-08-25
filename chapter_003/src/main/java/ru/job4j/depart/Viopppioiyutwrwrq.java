package ru.job4j.depart;

import javafx.print.Collation;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Viopppioiyutwrwrq {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");

        list.add("K1");
        list.add("K2\\SK1");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
//
//       ArrayList<String> qwe = new ArrayList<>();
//
//        TreeSet<String> li = new TreeSet<>();
//        li.add("K1");
//        li.add("K2");
//
//        ArrayList<String> res = new ArrayList<>();
//        for (String out : li) {
//            for (String s : list) {
//                if (s.startsWith(out)) {
//                    res.add(s);
//                }
//            }
//        }

//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() == o2.length() ? o2.compareTo(o1) : Integer.compare(o1.length(), o2.length());
//            }
//        });

//            for (String inn : list) {
//                if (inn.contains(a)) {
//                    qwe.add(inn);
//                }
//            }
        for (String o : list) {
            System.out.println(o);
        }

//        for (String o : qwe) {
//            System.out.println(o);
//        }

//        list.add("K1\\SK1");
//        list.add("K1\\SK2");
//        list.add("K1\\SK1\\SSK1");
//        list.add("K1\\SK1\\SSK2");
//        list.add("K2");
//        list.add("K2\\SK1\\SSK1");
//        list.add("K2\\SK1\\SSK2");

//        list.add("K1");
//        list.add("K1\\SK1");
//        list.add("K1\\SK2");
//        list.add("K1\\SK1\\SSK1");
//        list.add("K1\\SK1\\SSK2");
//
//        //Collections.sort(list, new Nme());
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        for (String o : list) {
//            System.out.println(o);
//        }
//
//        class Nme implements Comparator<String> {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        }

//        TreeSet<String> li = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        for (String s : list) {
//            Pattern p = Pattern.compile("^[a-zA-Z]*[0-9]*");
//            Matcher m = p.matcher(s);
//            while (m.find()) {
//                li.add(m.group());
//            }
//        }
//        for (String o : li) {
//            System.out.println(o);
//        }

//        li.add("K1");
//        li.add("K1\\SK1");
//        li.add("K1\\SK2");
//        li.add("K1\\SK1\\SSK1");
//        li.add("K1\\SK1\\SSK2");

//        Pattern p = Pattern.compile("^[a-zA-Z]*[0-9]*");
//        Matcher m = p.matcher("KL11\\SK1\\SSK1");
//        while (m.find()) {
//            list.add(m.group());
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        String s = "KL11\\SK1\\SSK1";
//        String[] mas = s.split("^[a-zA-Z]*[0-9]*");
//        for (int i = 0; i < mas.length; i++) {
//            System.out.println(mas[i]);
//        }

//        List<String> list = new ArrayList<>();
//
//        list.add("K1\\SK1");
//        list.add("K1\\SK2");
//        list.add("K1\\SK1\\SSK1");
//        list.add("K1\\SK1\\SSK2");
//        list.add("K2");
//        list.add("K2\\SK1\\SSK1");
//        list.add("K2\\SK1\\SSK2");

//        String joined = String.join("??", list); // «foo;bar;baz"
//        System.out.println(joined);
//        //List<String> a = list.subList(0, 1);
//
//        System.out.println(list.contains("Бобик"));
//
//
//        for (int i = 0; i < a.size(); i++) {
//            System.out.println(a.get(i));
//        }
    }
}
