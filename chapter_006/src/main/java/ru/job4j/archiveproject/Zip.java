package ru.job4j.archiveproject;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 01.09.2019.
 */
public class Zip {
    public void pack(String directory, String excule, String output) {
        List<File> fileAll = seekBy(directory, excule);
        File file  = new File(directory);
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(output)))) {
            for (var o : fileAll) {
                zip.putNextEntry(new ZipEntry(
                        o.getPath().substring(o.getPath().indexOf(file.getName()))));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(o))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * возвращает список файлов из папки.
     * @param root - из какой папки.
     * @param ext - кроме этого расширения
     * @return
     */
    List<File> seekBy(String root, String ext) {
        List<File> result = new ArrayList<>();
        File dir = new File(root);
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
                        if (!ext.equals(s)) {
                            result.add(file);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Args array = new Args(args);
        String directory = array.directory();
        String excule = array.excule();
        String output = array.output();
        new Zip().pack(directory, excule, output);
    }
}
//-d c:\project\job4j\Args -e *.xml -o pom.zip
//  new Zip().pack(new File("./chapter_006/Args"), new File("./chapter_006/pom.zip")