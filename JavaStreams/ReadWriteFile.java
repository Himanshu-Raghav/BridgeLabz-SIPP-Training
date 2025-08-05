package java_streams_package;

import java.io.*;
public class ReadWriteFile {
    public static void main(String[] args) {
    	
        //Define source and destination file names
        String sourceFile = "source.txt";        
        String destinationFile = "destination.txt";

        //Create file objects for source and destination
        File inputFile = new File(sourceFile);
        File outputFile = new File(destinationFile);

        //Check if the source file exists
        if (!inputFile.exists()) {
            System.out.println("Source file does not exist: " + sourceFile);
            return;
        }

        //Try-with-resources to automatically close the streams
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteData;

            //Read each byte from the source file and write it to the destination
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            //Success message
            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (IOException e) {
        	
            //Handle any IO exceptions 
            System.out.println("An error occurred during file handling: " + e.getMessage());
        }
    }
}
