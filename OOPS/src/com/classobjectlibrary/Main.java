package com.classobjectlibrary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Book book = new Book(title, author, price, true);
        System.out.println("Book Details:");
        book.displayDetails();

        System.out.print("Do you want to borrow the book? (yes/no): ");
        sc.nextLine(); 
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            book.borrowBook();
        }

        System.out.println("Updated Book Details:");
        book.displayDetails();

        sc.close();
    }
}

