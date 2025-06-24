package com.classobjectproduct;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter product price: ");
        double price1 = sc.nextDouble();
        sc.nextLine(); // consume newline

        Product p1 = new Product(name1, price1);

        System.out.print("Enter another product name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter product price: ");
        double price2 = sc.nextDouble();

        Product p2 = new Product(name2, price2);

        System.out.println("Product 1 Details:");
        p1.displayProductDetails();

        System.out.println("Product 2 Details:");
        p2.displayProductDetails();

        Product.displayTotalProducts();

        sc.close();
    }
}

