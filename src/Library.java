import Book.Book;
import Book.ScientificBook;
import Borrowing.Borrowing;
import Customer.Customer;
import Return.Return;

import java.io.IOException;
import java.util.ArrayList;


public class Library {

    private ArrayList<Book> listOfAllBooks;
    private ArrayList<Borrowing> listOfBorrowings;
    private ArrayList<Boolean> areThereAnyBooksBorrowed;


    public ArrayList<Book> getListOfAllBooks() {
        return listOfAllBooks;
    }

    public ArrayList<Borrowing> getListOfBorrowings() {
        return listOfBorrowings;
    }

    public ArrayList<Boolean> getAreThereAnyBooksBorrowed() {
        return areThereAnyBooksBorrowed;
    }

    public Library() {
        this.listOfAllBooks = new ArrayList<>();
        this.listOfBorrowings = new ArrayList<>();
        this.areThereAnyBooksBorrowed = new ArrayList<>();
    }



    void addNewBook(Book book) throws IOException {
        this.listOfAllBooks.add(book);
    }

    void removeBook(Book book) {
//        this.listOfAllBooks.remove(book);
        book.setRemoved(true);
    }

    void addBorrowingRecord(Book book, Customer customer) {
        book.setBorrowed(true);
        this.areThereAnyBooksBorrowed.add(true);
        book.setBorrowingCustomer(customer);
        book.getBorrowingCustomer().getBooksBorrowedByCustomer().add(book);
    }

    void addReturnRecord(Book book) {
        book.setBorrowed(false);
        this.areThereAnyBooksBorrowed.remove(true);
        book.getBorrowingCustomer().getBooksBorrowedByCustomer().remove(book);
    }
}
