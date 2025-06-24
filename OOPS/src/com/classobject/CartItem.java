package com.classobject;

import java.util.Scanner;

public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int qty) {
        quantity += qty;
    }

    public void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        } else {
            quantity = 0;
        }
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void displayCart() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + getTotalCost());
    }
}

