package ru.job4j.inout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class Chat {
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String FIN = "закончить";
    private String write;
    private String answer;

    public static void main(String[] args) throws IOException {
        //new Chat("C:\\projects\\job4j\\Chat.txt", "C:\\projects\\job4j\\Answer.txt").chat();
        new Chat("./Chat.txt", "./Answer.txt").chat();
    }

    public Chat(String write, String answer) {
        this.write = write;
        this.answer = answer;
    }

    /**
     * Метод работающего чата.
     */
    public void chat() throws IOException {
        List<String> list = makeListAnswer();
        boolean work = false;
        boolean stopAns = false;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter wr = new FileWriter(write)) {
            while (!work) {
                String s = reader.readLine();
                wr.write(String.format("%s%s", s, System.lineSeparator()));
                if (STOP.equals(s) && !stopAns) {
                    stopAns = true;
                } else if (CONTINUE.equals(s)) {
                    stopAns = false;
                    String ans = list.get((int) (Math.random() * list.size()));
                    System.out.println(ans);
                    wr.write(String.format("%s%s", ans, System.lineSeparator()));
                } else if (FIN.equals(s)) {
                    work = true;
                } else if (!stopAns) {
                    String ans = list.get((int) (Math.random() * list.size()));
                    System.out.println(ans);
                    wr.write(String.format("%s%s", ans, System.lineSeparator()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод преобразующий строки файла, из которого надо брать ответы, в список
     */
    public List<String> makeListAnswer() throws IOException {
        List<String> list = new ArrayList();
        BufferedReader reader = new BufferedReader(new FileReader(answer));
        while (reader.ready()) {
            String s = reader.readLine();
            list.add(s);
        }
        return list;
    }
}
