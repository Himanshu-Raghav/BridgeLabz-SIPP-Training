package object_modeling_package;

import java.util.*;

//Faculty class
class Faculty {
 String name;

 Faculty(String name) {
     this.name = name;
 }

 // Display faculty name
 public void show() {
     System.out.println("Faculty: " + name);
 }
}

//Department class
class Dept {
 String name;

 Dept(String name) {
     this.name = name;
 }

 // Display department name
 public void show() {
     System.out.println("Department: " + name);
 }
}

//University class
class University {
 String name;
 List<Dept> departments = new ArrayList<>();
 List<Faculty> faculties = new ArrayList<>(); 

 University(String name) {
     this.name = name;
 }

 // Add a department to the university 
 public void addDepartment(String deptName) {
     departments.add(new Dept(deptName));
 }

 // Add a faculty to the university
 public void addFaculty(Faculty f) {
     faculties.add(f);
 }

 // Show university detail
 public void showDetails() {
     System.out.println("\nUniversity: " + name);
     
     System.out.println("Departments:");
     for (Dept d : departments)
         d.show();

     System.out.println("Faculties:");
     for (Faculty f : faculties)
         f.show();
 }

 // Delete University
 public void deleteUniversity() {
     departments.clear();
     faculties.clear();   
     System.out.println("\nUniversity '" + name + "' deleted");
 }
}

//Main Method
public class UniversityFacultyDepartment {
 public static void main(String[] args) {
     Faculty f1 = new Faculty("Dr. Arora");
     Faculty f2 = new Faculty("Dr. Banerjee");

     University u1 = new University("ABC University");

     u1.addDepartment("Computer Science");
     u1.addDepartment("Mechanical");

     u1.addFaculty(f1);
     u1.addFaculty(f2);

     u1.showDetails();

     u1.deleteUniversity();

     System.out.println("\nFaculties still exist independently:");
     f1.show();
     f2.show();
 }
}

