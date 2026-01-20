package assignment5Ques1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DownloadManager {

    public static void main(String[] args) {

    	String filePath = "src/files.txt";
 // place it in project root
        int threadCount = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String url;
            while ((url = br.readLine()) != null) {

                FileDownloader task = new FileDownloader(url);
                Thread thread = new Thread(task, "Downloader-" + threadCount);
                thread.start();

                threadCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
