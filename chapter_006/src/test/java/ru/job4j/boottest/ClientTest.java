package ru.job4j.boottest;

import org.junit.Test;
import ru.job4j.boot.Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


public class ClientTest {
    private static final String LN = System.lineSeparator();

    private void testServer(String input, String expected) throws IOException {
        InputStream stdIn = System.in;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(new byte[]{0, 0});

        when(socket.getOutputStream()).thenReturn(out);
        when(socket.getInputStream()).thenReturn(in);

        Client bot = new Client(socket);
        bot.init();
        assertThat(out.toString(), is(expected));
        System.setIn(stdIn);
    }

    @Test
    public void whenQuitThenShowAnswer() throws IOException {
        this.testServer("exit", String.format("exit%s", LN));
    }
}
