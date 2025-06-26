package com.classobjectstudent;

public class Main {
    public static void main(String[] args) {
        PostgraduateStudent Student = new PostgraduateStudent(101, "Himanshu", 8.5);
        Student.showName();
        System.out.println("Roll Number: " + Student.rollNumber);
        System.out.println("CGPA: " + Student.getCGPA());

        Student.setCGPA(9.0);
        System.out.println("Updated CGPA: " + Student.getCGPA());
    }
}

