package object_modeling_package;

import java.util.*;


//Employee class
class Employee {
 String name;

 // Constructor
 Employee(String name) {
     this.name = name;
     System.out.println("Employee created: " + name);
 }

 // Method for deleting employee
 void cleanup() {
     System.out.println("Deleting Employee: " + name);
 }
}

//Department class
class Department {
 String name;
 List<Employee> employees = new ArrayList<>();

 // Constructor
 Department(String name) {
     this.name = name;
     System.out.println("Department created: " + name);
 }

 // Method for adding an employee to the department
 void addEmployee(String empName) {
     employees.add(new Employee(empName));
 }

 // Method for displaying department and employee details
 void display() {
     System.out.println("Department: " + name);
     for (Employee e : employees) {
         System.out.println("  Employee: " + e.name);
     }
 }

 // Method for deleting all employees
 void cleanup() {
     for (Employee e : employees) {
         e.cleanup();
     }
     System.out.println("Deleting Department: " + name);
 }
}

//Company class
class Company {
 String name;
 List<Department> departments = new ArrayList<>();

 // Constructor
 Company(String name) {
     this.name = name;
     System.out.println("Company created: " + name);
 }

 // Add a department to the company
 void addDepartment(String deptName) {
     departments.add(new Department(deptName));
 }

 // Add employee to a specific department
 void addEmployeeToDepartment(String deptName, String empName) {
     for (Department d : departments) {
         if (d.name.equals(deptName)) {
             d.addEmployee(empName);
         }
     }
 }

 // Display full company structure
 void display() {
     System.out.println("\nCompany: " + name);
     for (Department d : departments) {
         d.display();
     }
 }

 // Deleting the company and everything inside it
 void deleteCompany() {
     System.out.println("\nDeleting Company: " + name);
     for (Department d : departments) {
         d.cleanup();  
     }
     departments.clear(); 
     System.out.println("Company deleted: " + name);
 }
}

//Main Method
public class CompanyEmployee {
 public static void main(String[] args) {
     Company company = new Company("TechCorp");

     company.addDepartment("HR");
     company.addDepartment("IT");

     company.addEmployeeToDepartment("HR", "Alice");
     company.addEmployeeToDepartment("HR", "Bob");
     company.addEmployeeToDepartment("IT", "Charlie");

     company.display();

     company.deleteCompany();
 }
}


