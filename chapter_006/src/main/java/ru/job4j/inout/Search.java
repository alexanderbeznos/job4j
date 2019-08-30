package ru.job4j.inout;

import java.io.File;
import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 30.08.2019.
 */
public class Search {
    List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        File dir = new File(parent);
        Queue<File> queue = new LinkedList<>();
        queue.add(dir);
        while (!queue.isEmpty()) {
            File f = queue.poll();
            File[] list = f.listFiles();
            if (list != null) {
                for (File file : list) {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else {
                        String[] array = file.getName().split("\\.");
                        String s = String.format(".%s", array[1]);
                        for (String in : exts) {
                            if (s.equals(in)) {
                                result.add(file);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
