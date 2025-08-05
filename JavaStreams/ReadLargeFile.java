package java_streams_package;

import java.io.*;
public class ReadLargeFile {
    public static void main(String[] args) {
    	
    	//Path to the large text file
        String filePath = "largefile.txt"; 

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            //Read each line one by one
            while ((line = reader.readLine()) != null) {
            	
                //Check if line contains error
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
}
