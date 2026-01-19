package assignment3;

import java.io.*;
import java.util.Scanner;

public class CharStreamFileCopy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter source file path: ");
            String sourcePath = sc.nextLine();

            System.out.print("Enter destination file path: ");
            String destPath = sc.nextLine();

            FileReader reader = new FileReader(sourcePath);
            FileWriter writer = new FileWriter(destPath);

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }

            reader.close();
            writer.close();

            File sourceFile = new File(sourcePath);
            File destFile = new File(destPath);

            System.out.println("Character stream copy completed.");
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
