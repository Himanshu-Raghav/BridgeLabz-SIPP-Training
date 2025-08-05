package java_streams_package;

import java.io.*;
import java.util.*;

//Employee class implements Serializable
class Employee implements Serializable {
    int id;             
    String name;        
    String department;  
    double salary;      

    //Constructor
    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.department = dept;
        this.salary = salary;
    }

    //toString method to display employee info
    public String toString() {
        return id + " - " + name + " - " + department + " - Rs" + salary;
    }
}

public class SerializationSaveRetrieveObject {
    public static void main(String[] args) {
    	
    	//File to store serialized data
        String fileName = "employees.ser"; 

        //Create employees
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "HR", 50000));
        employeeList.add(new Employee(102, "Bob", "IT", 60000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 55000));

        //Serialize list to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employeeList); 
            System.out.println("Employees serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        //Deserialize list from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> loadedList = (List<Employee>) in.readObject(); 

            // Display employees
            System.out.println("Deserialized Employees:");
            for (Employee emp : loadedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
    }
}


