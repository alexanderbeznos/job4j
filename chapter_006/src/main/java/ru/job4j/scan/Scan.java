package ru.job4j.scan;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Scan {
    public static void main(String[] args) throws Exception {
        String[] array = research(args);
        Scan scan = new Scan();
        List<String> list = scan.find(array[0], array[1], array[2]);
        scan.loud(list, array);
    }

    /**
     * Метод кидает исключения и в отдельный массив записывает необходимые данные из args
     */
    public static String[] research(String[] args) throws Exception {
        String d = "Не задана директория в которой начинать поиск.";
        String n = "Не заданы имя файл, маска, либо регулярное выражение.";
        String m = "Не заданы действия";
        String o = "Не задан результат записи в файл";
        String[] listFor = new String[4];
        for (int i = 0; i < args.length - 1; i++) {
            String chek = args[i];
            if ("-d".equals(chek)) {
                listFor[0] = args[i + 1];
                d = null;
            } else if ("-n".equals(chek)) {
                String sel = args[i + 1];
                if (sel.startsWith("*")) {
                    sel = sel.replaceAll("\\*", "");
                }
                listFor[1] = sel;
                n = null;
            } else if ("-m".equals(chek)) {
                listFor[2] = "-m";
                m = null;
            } else if ("-f".equals(chek)) {
                listFor[2] = "-f";
                m = null;
            } else if ("-r".equals(chek)) {
                listFor[2] = "-r";
                m = null;
            } else if ("-o".equals(chek)) {
                listFor[3] = args[i + 1];
                o = null;
            }
        }
        if (d != null) {
            throw new Exception(d);
        }
        if (n != null) {
            throw new Exception(n);
        }
        if (m != null) {
            throw new Exception(m);
        }
        if (o != null) {
            throw new Exception(o);
        }
        return listFor;
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
