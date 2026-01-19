package assignment3;

import java.io.*;
import java.util.Scanner;

public class FileCopyPerformanceTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter source file path: ");
            String sourcePath = sc.nextLine();

            System.out.print("Enter destination file path (non-buffered): ");
            String destNonBuffered = sc.nextLine();

            System.out.print("Enter destination file path (buffered): ");
            String destBuffered = sc.nextLine();

            long timeWithoutBuffer = copyWithoutBuffer(sourcePath, destNonBuffered);
            long timeWithBuffer = copyWithBuffer(sourcePath, destBuffered);

            System.out.println("\n----- Performance Result -----");
            System.out.println("Without Buffering: " + timeWithoutBuffer + " ms");
            System.out.println("With Buffering: " + timeWithBuffer + " ms");
            System.out.println("Performance improved by: "
                    + (timeWithoutBuffer - timeWithBuffer) + " ms");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // ❌ Non-buffered byte stream copy
    private static long copyWithoutBuffer(String src, String dest)
            throws IOException {

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        long startTime = System.currentTimeMillis();

        int data;
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }

        long endTime = System.currentTimeMillis();

        fis.close();
        fos.close();

        return endTime - startTime;
    }

    // ✅ Buffered byte stream copy
    private static long copyWithBuffer(String src, String dest)
            throws IOException {

        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(dest));

        long startTime = System.currentTimeMillis();

        int data;
        while ((data = bis.read()) != -1) {
            bos.write(data);
        }

        long endTime = System.currentTimeMillis();

        bis.close();
        bos.close();

        return endTime - startTime;
    }
}

