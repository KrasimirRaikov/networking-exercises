import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
public class URLCommand {

    public static void main(String[] args) {
        try {
            URL url1 = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Cat_poster_1.jpg/1920px-Cat_poster_1.jpg");
            URLConnection connection=url1.openConnection();
            connection.connect();

            System.out.println(connection.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            URL url1= new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Cat_poster_1.jpg/1920px-Cat_poster_1.jpg");
//            URL wikipedia = new URL("https", "en.wikipedia.org", "wiki");
//            URL catURL= new URL("https://en.wikipedia.org/wiki/Cat#/media");
//            URL catBiology = new URL(catURL, "#Biology");
//            InputStream in= new BufferedInputStream(catBiology.openStream());
//            OutputStream out= new BufferedOutputStream(new FileOutputStream("out.html"));
//            int c;
//            while((c=in.read())!=-1){
//                out.write(c);
//            }
//            in.close();
//            out.close();
//            System.out.println("Done!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
