package assignment4;
//Ques1 Assignment 4
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void main(String[] args) throws Exception {

        // Step 1: Open the file
        BufferedReader br = new BufferedReader(new FileReader("story.txt"));

        // Step 2: Create a HashMap
        Map<String, Integer> map = new HashMap<>();

        String line;

        // Step 3: Read file line by line
        while ((line = br.readLine()) != null) {

            line = line.trim();          // remove extra spaces
            line = line.toLowerCase();   // convert to lowercase

            if (line.length() == 0)
                continue;

            // Step 4: Split line into words
            String[] words = line.split("\\s+");

            // Step 5: Count each word
            for (int i = 0; i < words.length; i++) {

                String word = words[i];

                if (map.containsKey(word)) {
                    int count = map.get(word);
                    map.put(word, count + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        br.close();

        // Step 6: Display result
        for (String key : map.keySet()) {
            System.out.println(key + " appears " + map.get(key) + " times");
        }
    }
}
