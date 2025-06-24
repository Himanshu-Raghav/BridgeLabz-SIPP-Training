package com.classobjectHotelBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking 1:");
        booking1.displayBooking();

        System.out.print("Enter guest name: ");
        String name = sc.nextLine();

        System.out.print("Enter room type: ");
        String room = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        HotelBooking booking2 = new HotelBooking(name, room, nights);
        System.out.println("Booking 2:");
        booking2.displayBooking();

        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Booking 3 (Copy of Booking 2):");
        booking3.displayBooking();

        sc.close();
    }
}
