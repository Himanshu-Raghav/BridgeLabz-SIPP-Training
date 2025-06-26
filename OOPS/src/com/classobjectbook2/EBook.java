package com.classobjectbook2;

public class EBook extends Book {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void showBookInfo() {
        System.out.println("EBook ISBN: " + ISBN);
        System.out.println("EBook Title: " + title);
    }
}
