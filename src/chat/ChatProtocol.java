package chat;

import java.io.IOException;
import java.util.*;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ChatProtocol {
    private Map<String, ChatThread> users= new HashMap<>();

    public void addUser(String clientName, ChatThread chatThread) throws IOException {
        sendMessage("System","\""+clientName+ "\" joined the chat");
        users.put(clientName, chatThread);
    }

    public void quitChat(String clientName) throws IOException {
        users.get(clientName).interrupt();
        users.remove(clientName);
        sendMessage("System", "\""+clientName+"\" left the chat");
    }

    public void sendMessage(String clientName, String message) throws IOException {
        for(String name: users.keySet()){
            if(!name.equals(clientName)) {
                users.get(name).sendMessage(clientName + ": " + message);
            }
        }
    }
}
