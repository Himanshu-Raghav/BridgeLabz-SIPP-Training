package com.classobject;
import java.util.Scanner;
import java.util.Scanner;

public class TotalCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter item code: ");
        String code = sc.nextLine();

        System.out.print("Enter item name: ");
        String name = sc.nextLine();

        System.out.print("Enter item price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        Item item = new Item(code, name, price);

        item.displayDetails();
        System.out.println("Total cost for " + quantity + " " + item.getItemName() + "(s): ₹" + item.calculateTotalCost(quantity));
    }
}
