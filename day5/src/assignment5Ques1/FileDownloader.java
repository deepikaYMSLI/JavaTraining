package assignment5Ques1;

import java.util.Random;

public class FileDownloader implements Runnable {

    private String fileUrl;

    public FileDownloader(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        System.out.println(Thread.currentThread().getName()
                + " - Starting download: " + fileName);

        try {
            Random random = new Random();
            int sleepTime = 200 + random.nextInt(301); // 200–500 ms
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                + " - Completed: " + fileName);
    }
}
