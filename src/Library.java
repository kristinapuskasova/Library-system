import Book.Book;
import Book.ScientificBook;
import Borrowing.Borrowing;
import Customer.Customer;
import Return.Return;

import java.io.IOException;
import java.util.ArrayList;


public class Library {

    private ArrayList<Book> listOfAllBooks;
    private ArrayList<Book> listOfBooksAvailable;
    private ArrayList<Book> listOfBorrowedBooks;

    public ArrayList<Book> getListOfBooksAvailable() {
        return listOfBooksAvailable;
    }

    public ArrayList<Book> getListOfBorrowedBooks() {
        return listOfBorrowedBooks;
    }

    public ArrayList<Book> getListOfAllBooks() {
        return listOfAllBooks;
    }

    public Library() {
        this.listOfAllBooks = new ArrayList<>();
        this.listOfBooksAvailable = new ArrayList<>();
        this.listOfBorrowedBooks = new ArrayList<>();
    }



    void addNewBook(Book book) throws IOException {
        this.listOfAllBooks.add(book);
        this.listOfBooksAvailable.add(book);
        }

    void removeBook(Book book) {
        this.listOfAllBooks.remove(book);
        this.listOfBooksAvailable.remove(book);
    }

    void borrowBook(Book book, Customer customer) {
        Borrowing b = new Borrowing();
        listOfBooksAvailable.remove(book);
        listOfBorrowedBooks.add(book);
        customer.getBooksBorrowedByCustomer().add(book);
        }

    void returnBook(Book book, Customer customer) {
        Return r = new Return();
        listOfBooksAvailable.add(book);
        listOfBorrowedBooks.remove(book);
        customer.getBooksBorrowedByCustomer().remove(book);
    }
}


