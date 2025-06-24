package com.classobjectperson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Person p1 = new Person(name, age);
        System.out.println("Original Person:");
        p1.display();

        Person p2 = new Person(p1);
        System.out.println("Cloned Person:");
        p2.display();

        sc.close();
    }
}
