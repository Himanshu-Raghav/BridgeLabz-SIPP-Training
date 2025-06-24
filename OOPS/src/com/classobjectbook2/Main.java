package com.classobjectbook2;

public class Main {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-3-16-148410-0", "Java Programming", "Ravi Sharma");
        ebook.showBookInfo();
        System.out.println("Author: " + ebook.getAuthor());

        ebook.setAuthor("Rahul Verma");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}

