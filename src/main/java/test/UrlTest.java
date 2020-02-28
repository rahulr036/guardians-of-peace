package test;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

public class UrlTest {

    public static void main(String[] args) {
        String url = "assignee=currentUser()&\"status not in\"(Closed,Cancelled,Done,Completed,\"In Use\",Resolved) ORDER BY updated DESC";
       // url = url.replaceAll(" ", "%20");

        String encodedUrl = getEncodedUrl(url);

        System.out.println(encodedUrl);

    }

    private static String getEncodedUrl(String url) {
        URLCodec urlCodec = new URLCodec();
        try {
            return urlCodec.encode(url);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        return null;
    }
}
