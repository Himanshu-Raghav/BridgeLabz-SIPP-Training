package com.classobjectemployee;

public class Main {
    public static void main(String[] args) {
        Manager mgr = new Manager(2001, "IT", 85000.0);
        mgr.showManagerDetails();
        System.out.println("Salary: ₹" + mgr.getSalary());

        mgr.setSalary(95000.0);
        System.out.println("Updated Salary: ₹" + mgr.getSalary());
    }
}

