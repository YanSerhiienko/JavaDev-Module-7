import homework.HttpImageStatusCli;
import homework.HttpStatusChecker;
import homework.HttpStatusImageDownloader;

import java.io.IOException;

public class HomeApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String statusImage = httpStatusChecker.getStatusImage(202);
        System.out.println(statusImage);

        new HttpStatusImageDownloader().downloadStatusImage(201);

        new HttpImageStatusCli().askStatus();
    }
}
