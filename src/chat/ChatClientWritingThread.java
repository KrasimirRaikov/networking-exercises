package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class ChatClientWritingThread extends Thread{
    private PrintWriter out;

    public ChatClientWritingThread(PrintWriter out) {
        this.out = out;
    }

    public void run(){
        try (BufferedReader stdIn= new BufferedReader(new InputStreamReader(System.in))){
            String fromUser;
            while(!(fromUser=stdIn.readLine()).equals("close chat")){
                out.println(fromUser);
                sleep(1000);
            }
            out.println("close chat");
            System.out.println("chat closed");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
