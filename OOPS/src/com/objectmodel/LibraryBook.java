package object_modeling_package;

import java.util.*;

//Book class
class Book {
 String title;
 String author;

 // Constructor
 Book(String title, String author) {
     this.title = title;
     this.author = author;
 }

 // Display method
 void displayBook() {
     System.out.println("Title: " + title + ", Author: " + author);
 }
}

//Library class
class Library {
 String name;
 ArrayList<Book> books;  // Aggregation

 // Constructor
 Library(String name) {
     this.name = name;
     books = new ArrayList<>();
 }

 // Method to add book to library
 void addBook(Book book) {
     books.add(book);
 }

 // Method to display all books
 void displayLibraryBooks() {
     System.out.println("Books in " + name + " Library:");
     for (Book book : books) {
         book.displayBook();
     }
     System.out.println();
 }
}

//Main Method
public class LibraryBook {
 public static void main(String[] args) {
     Book book1 = new Book("The Inheritance of Loss", "Kiran Desai ");
     Book book2 = new Book("The Story Of My Experiments With The Truth", "Mahatma Gandhi");
     Book book3 = new Book("The Guide", "R.K. Narayan");

     Library centralLibrary = new Library("Central");
     Library communityLibrary = new Library("Community");

     centralLibrary.addBook(book1);
     centralLibrary.addBook(book2);

     communityLibrary.addBook(book2); 
     communityLibrary.addBook(book3);

     centralLibrary.displayLibraryBooks();
     communityLibrary.displayLibraryBooks();
 }
}

