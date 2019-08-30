package ru.job4j.inout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class Analizy {
    public void unavailable(String source, String target) {
        List<String> listForWrite = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = read.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String start = null;
        String finish = null;
        boolean bool = true;
        for (var pair : list) {
            String[] array = pair.split(" ");
            if ((Integer.parseInt(array[0]) == 400 || (Integer.parseInt(array[0]) == 500)) && bool)   {
                start = array[1];
                bool = false;
            }
            if ((Integer.parseInt(array[0]) == 200 || (Integer.parseInt(array[0]) == 300)) && !bool) {
                finish = array[1];
                bool = true;
                listForWrite.add(String.format("%s;%s%s", start, finish, System.lineSeparator()));
            }
        }
        try {
            writer(listForWrite, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записывает в файл
     */
    public void writer(List<String> list, String target) throws IOException {
        try (FileWriter wr = new FileWriter(target)) {
            for (var o : list) {
                wr.write(o);
            }
        }
    }
//    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
