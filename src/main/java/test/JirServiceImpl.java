package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class JirServiceImpl implements JiraService {

    private static String jql = "IBP-122";

    private static final String url = "https://abouthere.atlassian.net/browse/" + jql;

    @Autowired
    public RestTemplateBuilder restTemplateBuilder;

    @Override
    public int getOpenDefects() {
        return 0;
    }

    public static void main(String[] args) {
        URL jiraURL;
        try {
            jiraURL = new URL("https://abouthere.atlassian.net");
            HttpURLConnection connection = (HttpURLConnection) jiraURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            String userCredentials = "rahul.ranjan@cybg.com:Plenty2010$";
            String basicAuth = "Basic " + Base64.getEncoder().encodeToString(userCredentials.getBytes());
            connection.setRequestProperty("Authorization", basicAuth);
            connection.connect();

            //

            /*System.out.println(url);

            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpGet getRequest = new HttpGet(url);

            getRequest.setHeader("Authorization", "Basic " + hashedAuth);

            getRequest.addHeader("accept", "application/json");
            HttpResponse response = httpClient.execute(getRequest);

            int statusCode = response.getStatusLine().getStatusCode();

            System.out.println(response.getStatusLine().getStatusCode());

            //** statusCode is 200

            if (statusCode == 200) {

                BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

                JSONParser parser = new JSONParser();

                Object replyObj = parser.parse(br);

                JSONObject jsonObject = (JSONObject) replyObj;

                System.out.println(jsonObject.toString());
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
