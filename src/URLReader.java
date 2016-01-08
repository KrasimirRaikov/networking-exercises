/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */

import java.net.URL;
import java.net.URLConnection;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://docs.oracle.com/javase/tutorial/essential/environment/properties.html");
        URLConnection urlConnection= url.openConnection();
        urlConnection.connect();
        System.out.println(urlConnection.getContentType());
        System.out.println(urlConnection.getContentLengthLong());
        //System.out.println(urlConnection.getContent());
//        InputStream in = new BufferedInputStream(url.openStream());
//        ByteArrayOutputStream out= new ByteArrayOutputStream();
//        byte[] buf= new byte[1024];
//        int n=0;
//        while (-1!=(n=in.read(buf))){
//            out.write(buf, 0, n);
//        }
//        out.close();
//        in.close();
//        byte[] response=out.toByteArray();
//
//        FileOutputStream fos= new FileOutputStream("cat.jpg");
//        fos.write(response);
//        fos.close();

        String[] files= url.getFile().split("/");
        System.out.println(files[files.length-1]);

    }
}