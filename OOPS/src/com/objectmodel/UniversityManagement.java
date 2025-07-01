package object_modeling1_package;

import java.util.*;


//Professor class
class Professor {
 String name;

 // Constructor
 Professor(String name) {
     this.name = name;
 }

 // Display professor name
 void show() {
     System.out.println("Professor: " + name);
 }
}

//Course class
class Course {
 String title; 
 Professor professor;
 List<Student> students = new ArrayList<>(); 

 // Constructor
 Course(String title) {
     this.title = title;
 }

 // Assign a professor to this course
 void assignProfessor(Professor p) {
     this.professor = p; 
     System.out.println("Professor " + p.name + " assigned to " + title);
 }

 // Enroll a student into this course
 void enrollStudent(Student s) {
     students.add(s); 
     System.out.println(s.name + " enrolled in " + title);
 }

 // Show course details
 void showDetails() {
     System.out.println("\nCourse: " + title);

     if (professor != null)
         System.out.println("Taught by: " + professor.name);

     System.out.println("Enrolled Students:");
     for (Student s : students) {
         System.out.println("- " + s.name);
     }
 }
}

//Student class
class Student {
 String name;

 // Constructor 
 Student(String name) {
     this.name = name;
 }

 // Method 
 void enrollCourse(Course c) {
     c.enrollStudent(this);
 }
}

//Main Method
public class UniversityManagement {
 public static void main(String[] args) {
     Student s1 = new Student("Anjali");
     Student s2 = new Student("Rahul");

     Professor p1 = new Professor("Dr. Mehta");

     Course c1 = new Course("Data Structures");

     c1.assignProfessor(p1);

     s1.enrollCourse(c1);
     s2.enrollCourse(c1);

     c1.showDetails();
 }
}
