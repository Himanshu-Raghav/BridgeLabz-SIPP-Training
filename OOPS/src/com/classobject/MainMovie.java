package com.classobject;

import java.util.Scanner;

public class MainMovie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        
        String movie = sc.nextLine();

        MovieTicket ticket = new MovieTicket(movie);

        System.out.print("Enter seat number: ");
        String seat = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        ticket.bookTicket(seat, price);
        ticket.displayDetails();
        sc.close();
    }
}

