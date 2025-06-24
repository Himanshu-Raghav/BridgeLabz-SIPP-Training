package com.classobjectcar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CarRental rental1 = new CarRental();
        System.out.println("Rental 1:");
        rental1.displayRentalDetails();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter car model (SUV/Sedan/Hatchback/Other): ");
        String model = sc.nextLine();

        System.out.print("Enter rental days: ");
        int days = sc.nextInt();

        CarRental rental2 = new CarRental(name, model, days);
        System.out.println("Rental 2:");
        rental2.displayRentalDetails();

        CarRental rental3 = new CarRental(rental2);
        System.out.println("Rental 3 (Copy of Rental 2):");
        rental3.displayRentalDetails();

        sc.close();
    }
}

