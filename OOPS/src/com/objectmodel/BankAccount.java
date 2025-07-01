package object_modeling_package;

//Customer class
class Customer {
 String name;
 int accountNumber;
 double balance;
 

 // Constructor
 Customer(String name) {
     this.name = name;
     this.balance = 0.0;
 }

 // Method to view balance
 void viewBalance() {
     System.out.println("Customer: " + name + ", Account No: " + accountNumber + ", Balance: Rs" + balance);
 }
}

//Bank class
class Bank {
 String name;
 int nextAccountNumber = 1234;

 // Constructor
 Bank(String name) {
     this.name = name;
 }

 // Method to open an account for a customer
 void openAccount(Customer customer) {
     customer.accountNumber = nextAccountNumber++;
     System.out.println("Account opened for " + customer.name + " in " + name + " bank. Account No: " + customer.accountNumber);
 }
}

//Main Method
public class BankAccount {
 public static void main(String[] args) {
     Bank icici = new Bank("SBI");

     Customer john = new Customer("John");
     Customer alice = new Customer("Alice");

     // Open accounts
     icici.openAccount(john);
     icici.openAccount(alice);

     // Check balances
     john.viewBalance();
     alice.viewBalance();
 }
}
