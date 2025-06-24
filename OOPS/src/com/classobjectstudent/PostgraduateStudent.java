package com.classobjectstudent;

public class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void showName() {
        System.out.println("Postgraduate Student Name: " + name);
    }
}

