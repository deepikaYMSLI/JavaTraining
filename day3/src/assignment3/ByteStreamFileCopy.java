package assignment3;

import java.io.*;
import java.util.Scanner;

public class ByteStreamFileCopy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter source file path: ");
            String sourcePath = sc.nextLine();

            System.out.print("Enter destination file path: ");
            String destPath = sc.nextLine();

            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destPath);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            fis.close();
            fos.close();

            File sourceFile = new File(sourcePath);
            File destFile = new File(destPath);

            System.out.println("Byte stream copy completed.");
            System.out.println("Source file size: " + sourceFile.length());
            System.out.println("Destination file size: " + destFile.length());

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");

        } catch (IOException e) {
            System.out.println("I/O Error occurred: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
