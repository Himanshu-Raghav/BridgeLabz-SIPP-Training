package java_streams_package;

import java.io.*;
public class StudentData {
    public static void main(String[] args) {
    	
    	//Binary file to store data
        String fileName = "studentdata.bin"; 

        //Sample data
        int roll = 101;               
        String name = "Alice";        
        double gpa = 8.7;             

        //Write data to binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(roll);       
            dos.writeUTF(name);       
            dos.writeDouble(gpa);     
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.err.println("Write error: " + e.getMessage());
        }

        //Read data from binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int r = dis.readInt();       
            String n = dis.readUTF();    
            double g = dis.readDouble();  

            //Print retrieved data
            System.out.println("\nRetrieved Data:");
            System.out.println("Roll: " + r);
            System.out.println("Name: " + n);
            System.out.println("GPA: " + g);
        } catch (IOException e) {
            System.err.println("Read error: " + e.getMessage());
        }
    }
}
