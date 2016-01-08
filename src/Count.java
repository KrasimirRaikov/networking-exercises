import java.io.IOException;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class Count {

    public static void main(String[] args) throws InterruptedException, IOException {
        final String operatingSystem = System.getProperty("os.name");
        ProcessBuilder pb = new ProcessBuilder("\033[H\033[2J");

        for (int i = 1; i <= 100; i++) {

            System.out.println(i);
            Thread.sleep(1000);

            pb.start();
//            System.out.print("\033[H\033[2J");
//            System.out.flush();
        }

    }
}
