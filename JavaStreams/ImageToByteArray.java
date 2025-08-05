package java_streams_package;

import java.io.*;
public class ImageToByteArray {
    public static void main(String[] args) {
    	
        //Original and new image file paths
        String inputImagePath = "original.jpg";   
        String outputImagePath = "copy.jpg";       

        try {
            //Read image into byte array
            FileInputStream fis = new FileInputStream(inputImagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 

            byte[] buffer = new byte[1024];        
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();
            fis.close();
            baos.close();

            //Convert byte array back to image using ByteArrayInputStream
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes); 
            FileOutputStream fos = new FileOutputStream(outputImagePath);    

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);     
            }

            bais.close();
            fos.close();

            System.out.println("Image successfully converted and written back.");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
