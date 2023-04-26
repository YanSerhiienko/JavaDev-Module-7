package homework;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String url = "https://http.cat/" + code + ".jpg";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        int statusCode = 0;

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            statusCode = response.statusCode();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        if (statusCode == 404) {
            throw new RuntimeException("There is no picture for status code " + code);
        }
        return url;
    }
}
