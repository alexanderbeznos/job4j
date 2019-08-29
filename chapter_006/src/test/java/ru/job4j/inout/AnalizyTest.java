package ru.job4j.inout;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class AnalizyTest {
    @Test
    public void whenMapWithDate() throws FileNotFoundException, IOException {
        Analizy file = new Analizy();
        file.unavailable("C:\\projects\\job4j\\Server.txt", "C:\\projects\\job4j\\unavailable.csv");
        BufferedReader reader = new BufferedReader(new FileReader("C:\\projects\\job4j\\unavailable.csv"));
        String result1 = reader.readLine();
        String result2 = reader.readLine();
        assertThat(result1, is("10:57:01;10:59:01"));
        assertThat(result2, is("11:01:02;11:02:02"));
    }
}








