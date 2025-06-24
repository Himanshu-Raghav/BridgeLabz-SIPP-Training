package com.classobjectcar;

public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    public CarRental() {
        customerName = "Customer";
        carModel = "Standard";
        rentalDays = 1;
        totalCost = calculateCost();
    }

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        totalCost = calculateCost();
    }

    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.rentalDays = other.rentalDays;
        this.totalCost = other.totalCost;
    }

    private double calculateCost() {
        double ratePerDay = switch (carModel.toLowerCase()) {
            case "suv" -> 70.0;
            case "sedan" -> 50.0;
            case "hatchback" -> 40.0;
            default -> 45.0;
        };
        return ratePerDay * rentalDays;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + totalCost);
    }
}
