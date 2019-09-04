package ru.job4j.archiveproject;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 01.09.2019.
 */
public class Args {
    String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    /**
     * -d - directory - которую мы ходим архивировать
     * -e - exclude - исключить файлы *.xml
     * -o - output - во что мы архивируем.
     */
    public String[] find() {
        String[] res = new String[3];
        for (int i = 0; i < args.length - 1; i++) {
            String chek = args[i];
            if ("-d".equals(chek)) {
                res[0] = args[i + 1];
            } else if ("-e".equals(chek)) {
                String fo = args[i + 1];
                res[1] = fo.replaceAll("\\*", "");
            } else if ("-o".equals(chek)) {
                res[2] = args[i + 1];
            }
        }
        return res;
    }
}
