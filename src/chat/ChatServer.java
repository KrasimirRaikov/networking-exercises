package chat;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ChatServer {

    public static void main(String[] args) {
        int portNumber= Integer.parseInt(args[0]);
        ChatProtocol chatProtocol= new ChatProtocol();
        boolean listening= true;
        try(
                ServerSocket serverSocket= new ServerSocket(portNumber)
                ) {
            while (listening) {
                new ChatThread(serverSocket.accept(), chatProtocol).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
