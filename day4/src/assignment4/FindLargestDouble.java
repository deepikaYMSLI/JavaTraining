package assignment4;
//Ques3 assignment 4
import java.io.*;
import java.util.*;

public class FindLargestDouble {

    public static void main(String[] args) {

        BufferedReader br = null;
        List<Double> list = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader("data.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                line = line.trim();

                if (line.length() == 0)
                    continue;

                try {
                    double value = Double.parseDouble(line);
                    list.add(value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number skipped: " + line);
                }
            }

            if (list.size() == 0) {
                System.out.println("File is empty or contains no valid numbers");
                return;
            }

            double max = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                }
            }

            System.out.println("Largest value: " + max);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {

            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}

