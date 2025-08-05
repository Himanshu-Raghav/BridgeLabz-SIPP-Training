package java_streams_package;

import java.io.*;
import java.util.*;
public class CountWords {
    public static void main(String[] args) {
    	
    	//Input file path
        String filePath = "sample.txt";
        
        //Store word frequency
        Map<String, Integer> wordCount = new HashMap<>(); 

        //Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            //Read each line
            while ((line = reader.readLine()) != null) {
            	
                //Split line into words using regex 
                String[] words = line.toLowerCase().split("\\W+");

                //Count words
                for (String word : words) {
                    if (!word.isEmpty()) { 
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        //Sort words by frequency in descending order
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        //Display top 5 frequent words
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
