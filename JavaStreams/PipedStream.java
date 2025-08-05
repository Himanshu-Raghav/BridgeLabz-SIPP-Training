package java_streams_package;

import java.io.*;
public class PipedStream {
    public static void main(String[] args) {
        try {
        	
            //Create piped input and output stream
            PipedOutputStream pos = new PipedOutputStream(); // For writing
            PipedInputStream pis = new PipedInputStream(pos); // Connected for reading

            //Writes data to output stream
            Thread writer = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread";
                    pos.write(message.getBytes()); 
                    pos.close(); 
                } catch (IOException e) {
                    System.err.println("Writer Error: " + e.getMessage());
                }
            });

            //Reads data from input stream
            Thread reader = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Reader received: ");
                    while ((data = pis.read()) != -1) { 
                        System.out.print((char) data); 
                    }
                    pis.close(); 
                } catch (IOException e) {
                    System.err.println("Reader Error: " + e.getMessage());
                }
            });

            //Start both threads
            reader.start();
            writer.start();

        } catch (IOException e) {
            System.err.println("Pipe connection error: " + e.getMessage());
        }
    }
}
