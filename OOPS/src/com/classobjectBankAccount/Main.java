package com.classobjectBankAccount;

public class Main {
    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount("SB10123456", "Meera Singh", 50000.0);
        acc.displayAccountDetails();
        System.out.println("Balance: ₹" + acc.getBalance());

        acc.deposit(10000.0);
        System.out.println("Updated Balance: ₹" + acc.getBalance());
    }
}

