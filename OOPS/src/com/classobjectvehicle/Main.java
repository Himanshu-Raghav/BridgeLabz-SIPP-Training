package com.classobjectvehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle.updateRegistrationFee(6000.0);

        System.out.print("Enter owner name: ");
        String owner = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        Vehicle v1 = new Vehicle(owner, type);
        System.out.println("Vehicle Details:");
        v1.displayVehicleDetails();

        sc.close();
    }
}

