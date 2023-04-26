package homework;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) {
        String image = new HttpStatusChecker().getStatusImage(code);

        try(InputStream in = new URL(image).openStream()){
            Files.copy(in, Paths.get("./" + code + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
