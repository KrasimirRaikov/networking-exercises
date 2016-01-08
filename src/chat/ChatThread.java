package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ChatThread extends Thread {
    private final Socket socket;
    private final ChatProtocol chatProtocol;

    public ChatThread(Socket socket, ChatProtocol chatProtocol) {
        this.socket = socket;
        this.chatProtocol = chatProtocol;
    }

    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            sendMessage("System: What's your name?");
            String clientName = in.readLine();

            chatProtocol.addUser(clientName, this);

            String inputMessage;
            while (!(inputMessage = in.readLine()).equals("close chat")) {
                chatProtocol.sendMessage(clientName, inputMessage);

            }

            chatProtocol.quitChat(clientName);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);

    }
}
