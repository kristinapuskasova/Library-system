package Book;


import Customer.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Book {

    public Book() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Title: ");
        this.title = reader.readLine();
        System.out.print("Author: ");
        this.author = reader.readLine();
        System.out.print("Page count: ");
        this.pageCount = Integer.parseInt(reader.readLine());
        this.isBorrowed = false;
        this.isRemoved = false;
    }

    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.isBorrowed = false;
        this.isRemoved = false;
    }

    private int pageCount;
    private String author;
    private String title;
    private boolean isBorrowed;
    private boolean isRemoved;
    private Customer borrowingCustomer;


    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }

    public Customer getBorrowingCustomer() {
        return borrowingCustomer;
    }

    public void setBorrowingCustomer(Customer borrowingCustomer) {
        this.borrowingCustomer = borrowingCustomer;
    }

    @Override
    public String toString() {
        String s;
        if (this.isBorrowed == false) {
            s = "Title: " + this.title + "\nAuthor: " + this.author + "\nPage Count: " + this.pageCount + "\nStatus: Currently available";
        } else {
            s = "Title: " + this.title + "\nAuthor: " + this.author + "\nPage Count: " + this.pageCount + "\nStatus: Currently unavailable";
        }
        return s;
    }
}