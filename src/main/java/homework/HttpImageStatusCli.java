package homework;

import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");

        String code = scanner.nextLine();
        while (!code.matches("[0-9]{3}")) {
            System.out.println("Please enter valid number");
            code = scanner.nextLine();
        }

        scanner.close();

        new HttpStatusImageDownloader().downloadStatusImage(Integer.parseInt(code));
    }
}
