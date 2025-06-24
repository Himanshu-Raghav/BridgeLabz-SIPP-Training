package com.variablemethodscircle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circle c1 = new Circle();
        System.out.println("Default Circle:");
        c1.display();

        System.out.print("Enter radius: ");
        double rad = sc.nextDouble();

        Circle c2 = new Circle(rad);
        System.out.println("User-defined Circle:");
        c2.display();

        sc.close();
    }
}
