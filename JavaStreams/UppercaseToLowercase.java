package java_streams_package;

import java.io.*;
public class UppercaseToLowercase {
    public static void main(String[] args) {
    	
    	//Input and output file path
        String inputFile = "input.txt";       
        String outputFile = "output.txt";     

        try (
        		
            //Reader with UTF-8 encoding
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8")
            );

            //Writer with UTF-8 encoding
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")
            )
        ) {
            String line; 

            //Read each line from input file
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); 
                writer.newLine();                 
            }

            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error during file processing: " + e.getMessage()); 
        }
    }
}
