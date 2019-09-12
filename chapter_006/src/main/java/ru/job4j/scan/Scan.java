package ru.job4j.scan;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scan {
    public static void main(String[] args) throws Exception {
        Arg arg = new Arg(args);
        String[] array = arg.research();
        Scan scan = new Scan();
        List<String> list = scan.find(array[0], array[1], array[2]);
        scan.loud(list, array);
    }

    /**
     * Метод переберает все папки у файлы в заданной папке
     */
    public List<String> find(String directory, String name, String make) {
        List<String> resul = new ArrayList<>();
        File dir = new File(directory);
        Queue<File> queue = new LinkedList<>();
        queue.add(dir);
        while (!queue.isEmpty()) {
            File f = queue.poll();
            File[] list = f.listFiles();
            if (list != null) {
                for (File file : list) {
                    if (file.isDirectory()) {
                        queue.add(file);
                    } else if ("-m".equals(make)) {
                        if (provM(file, name)) {
                            resul.add(file.getAbsolutePath());
                        }
                    } else if ("-f".equals(make)) {
                        if (provF(file, name)) {
                            resul.add(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
        return resul;
    }

    /**
     * Метод проверяет название рассматриваемого файла на совпадение с задаваемым при -f.
     */
    public boolean provF(File file, String tru) {
        boolean res = false;
        String s = file.getName();
        if (s.startsWith(tru)) {
            res = true;
        }
        return res;
    }

    /**
     * Метод проверяет название рассматриваемого файла на совпадение с задаваемым при -m.
     */
    public boolean provM(File file, String tru) {
        boolean res = false;
        String s = file.getName();
        if (s.endsWith(tru)) {
            res = true;
        }
        return res;
    }

    /**
     * Метод записсывает в заданный файл путь искомых файлов.
     */
    public void loud(List<String> list, String[] array) {
        try (FileWriter wri = (new FileWriter(array[3]))) {
            for (var o :list) {
                wri.write(o);
                wri.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
