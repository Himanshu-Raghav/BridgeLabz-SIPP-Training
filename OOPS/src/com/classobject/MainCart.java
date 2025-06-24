package com.classobject;

import java.util.Scanner;

public class MainCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter unit price: ");
        double price = sc.nextDouble();

        System.out.print("Enter initial quantity: ");
        int quantity = sc.nextInt();

        CartItem item = new CartItem(name, price, quantity);

        System.out.print("Enter quantity to add: ");
        int addQty = sc.nextInt();
        item.addItem(addQty);

        System.out.print("Enter quantity to remove: ");
        int removeQty = sc.nextInt();
        item.removeItem(removeQty);

        item.displayCart();
    }
}

