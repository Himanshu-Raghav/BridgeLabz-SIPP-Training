package com.classobjectonline;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course.updateInstituteName("Tech Academy");

        System.out.print("Enter course name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter course duration (in weeks): ");
        int duration = sc.nextInt();

        System.out.print("Enter course fee: ");
        double fee = sc.nextDouble();

        Course course1 = new Course(courseName, duration, fee);
        System.out.println("Course Details:");
        course1.displayCourseDetails();

        sc.close();
    }
}

