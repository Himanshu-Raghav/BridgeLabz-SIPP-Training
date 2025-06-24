package com.variablemethodsbook;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book();
        System.out.println("Default Book:");
        System.out.println("Title: " + book1.title);
        System.out.println("Author: " + book1.author);
        System.out.println("Price: " + book1.price);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter book author: ");
        String author = sc.nextLine();

        System.out.print("Enter book price: ");
        double price = sc.nextDouble();

        Book book2 = new Book(title, author, price);
        System.out.println("Parameterized Book:");
        System.out.println("Title: " + book2.title);
        System.out.println("Author: " + book2.author);
        System.out.println("Price: " + book2.price);

        sc.close();
    }
}

