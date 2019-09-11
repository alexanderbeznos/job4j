package ru.job4j.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void init() {
        String str;
        String question;
        try {
            System.out.println("Подключение состоялось.");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);
            do {
                question = console.nextLine();
                out.println(question);
                str = in.readLine();
                while (!str.isEmpty()) {
                    System.out.println(str);
                    str = in.readLine();
                }

            } while (!("exit").equals(question));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000);
        new Client(socket).init();
    }
}
