package ru.job4j.inout;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 30.08.2019.
 */
public class SearchTest {
    @Test
    public void whenTeste() throws IOException {
        List<String> list = List.of(".txt", ".xml");
        String s = System.getProperty("java.io.tmpdir");
        File dir1 = new File(s, "Direct1");
        dir1.mkdir();
        File dir2and1 = new File(dir1, "Direct2and1");
        dir2and1.mkdir();
        File dir2and2 = new File(dir1, "Direct2and2");
        dir2and2.mkdir();
        File dir3and1 = new File(dir2and1, "Direct3and1");
        dir3and1.mkdir();
        File dir3and2 = new File(dir2and2, "Direct3and2");
        dir3and2.mkdir();
        File file1and1 = File.createTempFile("file1and1", ".txt", dir1);
        File file1and2 = File.createTempFile("file1and2", ".xml", dir1);
        File file1and3 = File.createTempFile("file2and1", ".html", dir2and1);
        File file1and4 = File.createTempFile("file2and2", ".txt", dir2and2);
        File file1and5 = File.createTempFile("file3and1", ".html", dir3and1);
        File file1and6 = File.createTempFile("file3and2", ".txt", dir3and2);
        Search file = new Search();
        List<File> result = file.files(dir1.getAbsolutePath(), list);
        List<File> expect = List.of(file1and1, file1and2, file1and4, file1and6);
        assertThat(result.containsAll(expect), is(true));
    }
}
