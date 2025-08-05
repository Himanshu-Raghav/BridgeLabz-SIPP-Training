package java_streams_package;

import java.io.*; 
public class UserInputConsole {
    public static void main(String[] args) {
    	
    	//Reading user input
        BufferedReader reader = null;
        
        //Writing to file
        FileWriter writer = null;     

        try {
        	
        	//Create buffer reader
            reader = new BufferedReader(new InputStreamReader(System.in)); 

            System.out.print("Enter your name: "); 
            String name = reader.readLine();       

            System.out.print("Enter your age: ");  
            String age = reader.readLine();        

            System.out.print("Enter your favorite programming language: "); 
            String language = reader.readLine();                            

            String data = "Name: " + name + "\nAge: " + age + "\nFavorite Language: " + language; 

            //Create file writer
            writer = new FileWriter("user_info.txt");
            
            //Write data to file
            writer.write(data); 
            
            //Success message  
            System.out.println("Information saved to user_info.txt");
            
        }
        
        catch (IOException e) {
        	
        	//Print error
            System.out.println("An error occurred: " + e.getMessage()); 
        } 
        
        finally {
            try {
                if (reader != null) reader.close(); 
                if (writer != null) writer.close(); 
            } 
            
            catch (IOException e) {
            	
            	//Closing error
                System.out.println("Failed to close streams: " + e.getMessage()); 
            }
        }
    }
}
