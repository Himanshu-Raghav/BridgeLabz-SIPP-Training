
package object_modeling_package;

import java.util.*;

//Student class
class Student {
 String name;
 List<Course> courses = new ArrayList<>(); // List of courses the student is enrolled in

 Student(String name) {
     this.name = name;
 }

 // Method to enroll in a course
 public void enroll(Course c) {
     courses.add(c);           
     c.students.add(this);    
 }

 // Show all courses student is enrolled in
 public void showCourses() {
     System.out.println(name + " is enrolled in:");
     for (Course c : courses)
         System.out.println("- " + c.name);
 }
}

//Course class
class Course {
 String name;
 List<Student> students = new ArrayList<>(); 

 Course(String name) {
     this.name = name;
 }

 // Show all students enrolled in this course
 public void showStudents() {
     System.out.println("Students in " + name + ":");
     for (Student s : students)
         System.out.println("- " + s.name);
 }
}

//School class
class School {
 String name;
 List<Student> students = new ArrayList<>();

 School(String name) {
     this.name = name;
 }

 // Add a student to the school
 public void addStudent(Student s) {
     students.add(s);
 }

 // Show all students in the school
 public void showStudents() {
     System.out.println("Students in " + name + ":");
     for (Student s : students)
         System.out.println("- " + s.name);
 }
}

//Main class
public class SchoolSystem {
 public static void main(String[] args) {
     School school = new School("Greenwood");

     Student s1 = new Student("Alice");
     Student s2 = new Student("Bob");

     Course c1 = new Course("Math");
     Course c2 = new Course("Science");

     school.addStudent(s1);
     school.addStudent(s2);

     s1.enroll(c1);
     s1.enroll(c2);
     s2.enroll(c1);

     school.showStudents();  
     s1.showCourses();       
     s2.showCourses();       
     c1.showStudents();      
     c2.showStudents();      
 }
}
