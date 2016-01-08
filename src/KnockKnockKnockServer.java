import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class KnockKnockKnockServer {

    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        boolean listening= true;

        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);

        ) {


            while(listening){
                new KKKMultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
