package app;

/**
 * Java8
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.StringBuilder;

/**
 * Java 11
 */
// import java.net.URI;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.nio.charset.StandardCharsets;

/**
 * api/recursive/ask API
 */
public class AskServerService {

    String seed;

    public AskServerService(String seed) {
        this.seed = seed;
    }

    public Integer request(int n) {

        Integer result = -1;
        String strUrl = "https://codecheck-challenge-api.herokuapp.com/api/recursive/ask?n=" + n + "&seed=" + seed;

        /**
         * java 8
         */
        HttpURLConnection  urlConn = null;
        InputStream in = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(strUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.connect();
            int status = urlConn.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                in = urlConn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                result = Integer.parseInt(Logic.transJsonMapFromResponse(response.toString()).get("result"));
            } else {
                in = urlConn.getErrorStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder error = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    error.append(line);
                }
                System.out.println("HTTPエラー:" + error);
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (urlConn != null) {
                    urlConn.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;

        /**
         * Java 11
         */
        // try {
        //     HttpRequest request = HttpRequest
        //             .newBuilder(URI.create(strUrl)
        //             .build();
        //     HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8);
        //     HttpResponse<String> response = HttpClient.newBuilder().build().send(request, bodyHandler);
        //     result = gerResultProperty(response.body());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // return result;
    }
}
