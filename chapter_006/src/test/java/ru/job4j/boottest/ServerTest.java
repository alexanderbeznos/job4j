package ru.job4j.boottest;

import com.google.common.base.Joiner;
import org.junit.Test;
import ru.job4j.boot.Server;
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ServerTest {
    private static final String LN = System.lineSeparator();

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);
        Server bot = new Server(socket);
        bot.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenQuitThenShowAnswer() throws IOException {
        this.testServer("exit", String.format("Good Bye!%s%s", LN, LN));
    }

    @Test
    public void whenHelloThenShowAnswer() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "Hello",
                        "exit"
                ), Joiner.on(LN).join(
                        "Hello, I'm oracle.",
                        "",
                        "Good Bye!",
                        "",
                        ""
                ));
    }

    @Test
    public void whenUnsupportedThenShowAnswer() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "What's up?",
                        "exit"
                ), Joiner.on(LN).join(
                        "I don't no",
                        "",
                        "Good Bye!",
                        "",
                        ""
                ));
    }
}
