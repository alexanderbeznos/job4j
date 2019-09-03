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
     */
    public String directory() {
        String res = null;
        for (int i = 0; i < args.length - 1; i++) {
            String chek = args[i];
            if ("-d".equals(chek)) {
                res = args[i + 1];
            }
        }
        return res;
    }

    /**
     * -e - exclude - исключить файлы *.xml
     */
    public String excule() {
        String result = null;
        for (int i = 0; i < args.length - 1; i++) {
            String chek = args[i];
            if ("-e".equals(chek)) {
                String res = args[i + 1];
                result = res.replaceAll("\\*", "");
            }
        }
        return result;
    }

    /**
     * -o - output - во что мы архивируем.
     */
    public String output() {
        String res = null;
        for (int i = 0; i < args.length - 1; i++) {
            String chek = args[i];
            if ("-o".equals(chek)) {
                res = args[i + 1];
            }
        }
        return res;
    }
}
