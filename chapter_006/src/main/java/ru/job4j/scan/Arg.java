package ru.job4j.scan;

public class Arg {
    String[] args;

    public Arg(String[] args) {
        this.args = args;
    }

    /**
     * Метод кидает исключения и в отдельный массив записывает необходимые данные из args
     */
    public String[] research() throws Exception {
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
}
