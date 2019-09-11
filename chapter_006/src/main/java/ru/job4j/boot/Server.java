package ru.job4j.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private Socket socket;
    private Map<String, String> ansMap = new HashMap<>();

    public Server(Socket socket) {
        this.socket = socket;
        ansMap.put("Hello", "Hello, I'm oracle.");
        ansMap.put("How are you?", "I am fine");
        ansMap.put("What is the weather today?", "It is sunny");
        ansMap.put("exit", "Good Bye!");
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void start() {
        String ask;
        try {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                String answer = ansMap.get(ask) == null ? "I don't no" : ansMap.get(ask);
                out.println(answer);
                out.println();
                out.flush();
            } while (!("exit".equals(ask)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
