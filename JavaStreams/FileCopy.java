package java_streams_package;

import java.io.*;
public class FileCopy {
    public static void main(String[] args) throws IOException {
    	
        //Source and destination file paths 
        String source = "source.txt";             
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";

        int bufferSize = 4096; 

        //Buffered Stream Copy Section
        long startBuffered = System.nanoTime(); 

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destBuffered))) {
            
            byte[] buffer = new byte[bufferSize]; 
            int bytesRead;

            //Read and write 
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }

        long timeBuffered = System.nanoTime() - startBuffered; 

        //Unbuffered Stream Copy Section
        long startUnbuffered = System.nanoTime(); 

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destUnbuffered)) {
            
            byte[] buffer = new byte[bufferSize]; 
            int bytesRead;

            //Read and write
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }

        long timeUnbuffered = System.nanoTime() - startUnbuffered; 

        //Print Performance Time
        System.out.println("Buffered Stream Time (ns): " + timeBuffered);
        System.out.println("Unbuffered Stream Time (ns): " + timeUnbuffered);
    }
}
