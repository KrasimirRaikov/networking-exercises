import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class KKKMultiServerThread extends Thread{
    private Socket clientSocket;

    public KKKMultiServerThread(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }

    public void run(){
        try(
                PrintWriter out= new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))

                ) {
            String inputLine, outputLine;
            KnockKnockKnockProtocol kkkp= new KnockKnockKnockProtocol();
            outputLine= kkkp.processInput(null);
            out.println(outputLine);

            while((inputLine=in.readLine())!=null){
                outputLine= kkkp.processInput(inputLine);
                out.println(outputLine);
                if(outputLine.equals("Bye.")){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
