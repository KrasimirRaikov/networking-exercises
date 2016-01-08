package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ChatClient {

    public static void main(String[] args) {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        try (
                Socket socket = new Socket(host, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String fromServer;
            ChatClientWritingThread ccwt = new ChatClientWritingThread(out);
            ccwt.start();

            while (true) {
                try {
                    while ((fromServer = in.readLine()) != null) {
                        System.out.println(fromServer);
                    }
                } catch (SocketTimeoutException ignored) {
                }

                if (!ccwt.isAlive()) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
