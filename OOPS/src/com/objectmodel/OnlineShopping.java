package object_modeling1_package;


import java.util.*;

//Product class
class Product {
 String name;
 double price;

 Product(String name, double price) {
     this.name = name;
     this.price = price;
 }

 public void showDetails() {
     System.out.println("Product: " + name + ", Price: Rs" + price);
 }
}

//Order class
class Order {
 int orderId;
 List<Product> products = new ArrayList<>();
 Customer customer;

 Order(int orderId, Customer customer) {
     this.orderId = orderId;
     this.customer = customer;
     System.out.println("Order No" + orderId + " created by " + customer.name);
 }

 // Add a product to the order
 public void addProduct(Product p) {
     products.add(p);
     System.out.println("Added product to Order No" + orderId + ": " + p.name);
 }

 // Show all products in this order
 public void showOrderDetails() {
     System.out.println("\nOrder No" + orderId + " by " + customer.name + " includes:");
     for (Product p : products)
         p.showDetails();
 }
}

//Customer class
class Customer {
 String name;
 List<Order> orders = new ArrayList<>();

 Customer(String name) {
     this.name = name;
 }

 // Place a new order
 Order placeOrder(int orderId) {
     Order newOrder = new Order(orderId, this);
     orders.add(newOrder);
     return newOrder;
 }

 // Show all orders placed by this customer
 void showOrders() {
     System.out.println("\nOrders placed by " + name + ":");
     for (Order o : orders)
         System.out.println("- Order ID: " + o.orderId);
 }
}

//Main Method
public class OnlineShopping {
 public static void main(String[] args) {
     Product p1 = new Product("Laptop", 55000);
     Product p2 = new Product("Smartphone", 25000);
     Product p3 = new Product("Headphones", 1500);

     Customer c1 = new Customer("Ravi");

     Order o1 = c1.placeOrder(101);
     o1.addProduct(p1);
     o1.addProduct(p3);

     Order o2 = c1.placeOrder(102);
     o2.addProduct(p2);

     c1.showOrders();
     o1.showOrderDetails();
     o2.showOrderDetails();
 }
}

