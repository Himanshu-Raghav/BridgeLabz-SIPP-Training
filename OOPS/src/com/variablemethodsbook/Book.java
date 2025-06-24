package com.variablemethodsbook;

public class Book {
    String title;
    String author;
    double price;

    public Book() {
        title = "";
        author = "";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

