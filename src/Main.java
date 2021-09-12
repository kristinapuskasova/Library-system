import Book.Book;
import Book.ScientificBook;
import Book.ForeignBook;
import Borrowing.Borrowing;
import Customer.Customer;
import Customer.Customer.Address;
import Customer.CustomerManager;
import Return.Return;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Library myLibrary = new Library();
        CustomerManager customerManager = new CustomerManager();


        Book book1 = new Book("Alice in Wonderland", "Lewis Caroll", 200);
        Book book2 = new ScientificBook("A Brief History of Time", "Stephen Hawking", 256, "Cosmology");
        Book book3 = new ForeignBook("Les Miserables", "Victor Hugo", 1462, "French");
        myLibrary.addNewBook(book1);
        myLibrary.addNewBook(book2);
        myLibrary.addNewBook(book3);

        Address address1 = new Address("North Los Robles Avenue", 2311, "Pasadena", "California");
        Address address2 = new Address("North Los Robles Avenue", 2311, "Pasadena", "California");
        Address address3 = new Address("Altadena", 2200, "Pasadena", "California");

        Customer customer1 = new Customer("Leonard", "Hofstadter", address1);
        Customer customer2 = new Customer("Sheldon", "Cooper", address2);
        Customer customer3 = new Customer("Howard", "Wolowitz", address3);
        customerManager.addNewCustomer(customer1);
        customerManager.addNewCustomer(customer2);
        customerManager.addNewCustomer(customer3);

        System.out.println("\n**** Welcome to Ness Academy Library! ****\n");
        System.out.println("Choose one of the following options (0-9):");
        System.out.println("0: Exit application \n1: Add a new book to the Library\n2: List all books in the Library\n3: List all books available for borrowing\n4: Remove a book from the Library\n5: Borrow a book\n6: Return a book\n7: List all customers\n8: Add a new customer\n9: Update customer's address\n");


        int exitNum = 1;

        while (exitNum != 0) {
            System.out.print("Your choice: ");
            int option = scanner.nextInt();

                    switch (option) {
                        case 0 :
                            System.out.println("Thank you for coming! See you next time!");
                            exitNum = 0;
                            break;

                        case 1: //add book
                            System.out.println("ADD BOOK\n");
                            System.out.print("Select one of the following Book Types: \n1: Standard\n2: Scientific\n3: Foreign\n\nSelected Book Type: ");
                            while (true) {
                                try {
                                    int bookType = scanner.nextInt();

                                    switch (bookType) {
                                        case 1: //standard book
                                            Book standardBook = new Book();
                                            myLibrary.addNewBook(standardBook);
                                            System.out.println("You've just added " + standardBook.getTitle() + " by " + standardBook.getAuthor() + " to the Library!\n");
                                            break;

                                        case 2: //scientific book
                                            Book scientificBook = new ScientificBook();
                                            myLibrary.addNewBook(scientificBook);
                                            System.out.println("You've just added " + scientificBook.getTitle() + " by " + scientificBook.getAuthor() + " to the Library!\n");
                                            break;

                                        case 3: //foreign book
                                            Book foreignBook = new ForeignBook();
                                            myLibrary.addNewBook(foreignBook);
                                            System.out.println("You've just added " + foreignBook.getTitle() + " by " + foreignBook.getAuthor() + " to the Library!\n");
                                            break;

                                        default: //non-existing booktype
                                            System.out.println(bookType + "is not a valid option. Please, choose a number from 1 - 3");
                                    } break;


                                } catch (Exception e) {
                                    scanner.next();
                                    System.out.println("That is not a number. Please, try again.\n");
                                    System.out.print("Select book type: ");
                                }
                            } break;

                        case 2: //show list of all books
                            System.out.println("LIST OF ALL BOOKS\n");
                            for (int i = 0; i < myLibrary.getListOfAllBooks().size(); i++) {
                                if (myLibrary.getListOfAllBooks().get(i).isRemoved() == false) {
                                    System.out.println("Book No. " + (i +1) + ":\n" + myLibrary.getListOfAllBooks().get(i).toString() + "\n");
                                }
                            } break;

                        case 3: //list books available for borrowing
                            System.out.println("LIST OF AVAILABLE BOOKS\n");
                            for (int i = 0; i < myLibrary.getListOfAllBooks().size(); i++) {
                                if ((myLibrary.getListOfAllBooks().get(i).isBorrowed() == false) && (myLibrary.getListOfAllBooks().get(i).isRemoved() == false)) {
                                    System.out.println("Book No. " + (i + 1) + ":\n" + myLibrary.getListOfAllBooks().get(i).toString() + "\n");
                                }
                            } break;

                        case 4: //remove book
                            System.out.println("REMOVE BOOK\n");
                            System.out.print("Remove book No.: ");
                            while (true) {
                                try {
                                    int bookToBeRemoved = scanner.nextInt();
                                    int bookToBeRemovedIndex = bookToBeRemoved - 1;
                                    if (!(bookToBeRemoved > myLibrary.getListOfAllBooks().size()) && !(bookToBeRemoved < 1)) {
                                        if (myLibrary.getListOfAllBooks().get(bookToBeRemovedIndex).isBorrowed() == false) {
                                            if (myLibrary.getListOfAllBooks().get(bookToBeRemovedIndex).isRemoved() == false) {
                                                myLibrary.removeBook(myLibrary.getListOfAllBooks().get(bookToBeRemovedIndex));
                                                System.out.println("You've removed " + myLibrary.getListOfAllBooks().get(bookToBeRemovedIndex).getTitle() + " by " + myLibrary.getListOfAllBooks().get(bookToBeRemovedIndex).getAuthor() + " from the Library\n");
                                            } else {
                                                System.out.println("Book No. " + bookToBeRemoved + " (" + myLibrary.getListOfAllBooks().get(bookToBeRemovedIndex).getTitle()+ ")"  + " has already been removed.\n");
                                            }
                                        } else {
                                            System.out.println("This book cannot be removed as it has not been returned yet.\n");
                                        }
                                    } else {
                                        System.out.println("There is no book with ID #" + bookToBeRemoved + " in the Library.\n");
                                    } break;
                                } catch (Exception e) {
                                    scanner.next();
                                    System.out.println("That is not a number. Please, try again.\n");
                                    System.out.print("Remove book No.: ");
                                }
                            } break;

                        case 5: //borrow a book
                            System.out.println("BORROW BOOK\n");
                            System.out.print("Borrow book No.: ");

                            while (true) {
                                try {
                                    int bookToBeBorrowed = scanner.nextInt();
                                    int bookToBeBorrowedIndex = bookToBeBorrowed - 1;

                                    if (!(bookToBeBorrowed > myLibrary.getListOfAllBooks().size()) && !(bookToBeBorrowed < 1)) {
                                        if (myLibrary.getListOfAllBooks().get(bookToBeBorrowedIndex).isRemoved() == false) {
                                            if (myLibrary.getListOfAllBooks().get(bookToBeBorrowedIndex).isBorrowed() == false) {
                                                System.out.print("Enter customer No.: ");
                                                int borrowingCustomer = scanner.nextInt();
                                                int borrowingCustomerIndex = borrowingCustomer - 1;

                                                if (customerManager.getListOfCustomers().get(borrowingCustomerIndex).getBooksBorrowedByCustomer().size() < 3) {
                                                    Borrowing b = new Borrowing(customerManager.getListOfCustomers().get(borrowingCustomerIndex));
                                                    myLibrary.addBorrowingRecord(myLibrary.getListOfAllBooks().get(bookToBeBorrowedIndex), customerManager.getListOfCustomers().get(borrowingCustomerIndex));
                                                    System.out.println("Book " + myLibrary.getListOfAllBooks().get(bookToBeBorrowedIndex).getTitle() + " by " + myLibrary.getListOfAllBooks().get(bookToBeBorrowedIndex).getAuthor() + " was borrowed by " + customerManager.getListOfCustomers().get(borrowingCustomerIndex).getFirstName() + " " + customerManager.getListOfCustomers().get(borrowingCustomerIndex).getLastName() + " on " + b.getDateOfBorrowing() + "\n");
                                                } else {
                                                    System.out.println("Maximum limit of borrowed books per customer (3) has been reached.\n");
                                                }
                                            } else {
                                                System.out.println("Book " + myLibrary.getListOfAllBooks().get(bookToBeBorrowedIndex).getTitle() + " has already been borrowed.\n");
                                            }
                                        } else {
                                            System.out.println("There is no book with ID #" + bookToBeBorrowed + " in the Library.\n");
                                        }
                                    } else {
                                        System.out.println("There is no book with ID #" + bookToBeBorrowed + " in the Library.\n");
                                    } break;
                                } catch (Exception e) {
                                    scanner.next();
                                    System.out.println("That is not a number. Please, try again.\n");
                                    System.out.print("Borrow book No.: ");
                                }
                            } break;

                        case 6: //return a book
                            System.out.println("RETURN BOOK\n");
                            if (!myLibrary.getAreThereAnyBooksBorrowed().isEmpty()) {
                                System.out.println("List of borrowed books:\n");
                                for (int i = 0; i < myLibrary.getListOfAllBooks().size(); i++) {
                                    if ((myLibrary.getListOfAllBooks().get(i).isBorrowed() == true) && (myLibrary.getListOfAllBooks().get(i).isRemoved() == false)) {

                                        System.out.println("Book No. " + (i + 1) + ":\n" + myLibrary.getListOfAllBooks().get(i).toString() + "\nBorrowed by: " + myLibrary.getListOfAllBooks().get(i).getBorrowingCustomer().getFirstName() + " " + myLibrary.getListOfAllBooks().get(i).getBorrowingCustomer().getLastName() + "\n");
                                    }
                                }
                                        System.out.print("Select the book you wish to return: ");

                                        while (true) {
                                            try {
                                                int bookToBeReturned = scanner.nextInt();
                                                int bookToBeReturnedIndex = bookToBeReturned - 1;

                                                if (!(bookToBeReturned > myLibrary.getListOfAllBooks().size()) && !(bookToBeReturned < 1)) {
                                                    if(myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex).isBorrowed() == true) {
                                                        Return r = new Return();
                                                        myLibrary.addReturnRecord(myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex));
                                                        System.out.println("Customer " + myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex).getBorrowingCustomer().getFirstName() + " " + myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex).getBorrowingCustomer().getLastName() + " returned Book " + myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex).getTitle() + " by " + myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex).getAuthor() + " on " + r.getDateOfReturn() + "\n");
                                                        myLibrary.getListOfAllBooks().get(bookToBeReturnedIndex).setBorrowingCustomer(null);

                                                    } else {
                                                        System.out.println("This book has not been borrowed.\n");
                                                    }
                                                } else {
                                                    System.out.println("There is no book with ID #" + bookToBeReturned + " in the Library.\n");
                                                } break;
                                            } catch (Exception e) {
                                                scanner.next();
                                                System.out.println("That is not a number. Please, try again.\n");
                                                System.out.print("Return book No.: ");
                                            }
                                        } break;

                            } else {
                                System.out.println("Currently, there are no books to be returned.\n");
                            } break;

                        case 7: //show list of all customers
                            System.out.println("LIST OF ALL CUSTOMERS\n");
                            for (int i = 1; i <= customerManager.getListOfCustomers().size(); i++) {
                                System.out.println("Customer No. " + i + ":\n" + customerManager.getListOfCustomers().get(i-1).toString() + "\n");
                            }
                            break;

                        case 8: //add new customer
                            System.out.println("ADD CUSTOMER\n");
                            Customer customer = new Customer();
                            customerManager.addNewCustomer(customer);
                            break;

                        case 9: //update address
                            System.out.println("UPDATE ADDRESS\n");
                            System.out.print("Change the address of customer No.: ");
                            while (true) {
                                try {

                                    int customerNo = scanner.nextInt();
                                    int customerIndex = customerNo - 1;

                                    if (!(customerNo > customerManager.getListOfCustomers().size()) && !(customerNo < 1)) {
                                        System.out.print("New Street Name: ");
                                        scanner.nextLine();
                                        String newStreetName = scanner.nextLine();
                                        customerManager.getListOfCustomers().get(customerIndex).getAddress().setStreetName(newStreetName);

                                        System.out.print("New Street Number: ");
                                        int newStreetNumber = scanner.nextInt();
                                        customerManager.getListOfCustomers().get(customerIndex).getAddress().setStreetNumber(newStreetNumber);

                                        System.out.print("New City: ");
                                        scanner.nextLine();
                                        String newCity = scanner.nextLine();
                                        customerManager.getListOfCustomers().get(customerIndex).getAddress().setCity(newCity);

                                        System.out.print("New Country: ");
                                        String newCountry = scanner.nextLine();
                                        customerManager.getListOfCustomers().get(customerIndex).getAddress().setCountry(newCountry);
                                        System.out.println();
                                        break;

                                    } else {
                                        System.out.println("Customer with ID #" + customerNo + " has not been registered.\n");
                                    } break;

                                } catch (Exception e) {
                                    scanner.next();
                                    System.out.println("That is not a number. Please, try again.\n");
                                    System.out.print("Customer No.: ");
                                }
                            } break;

                        default: //non-existing option
                            System.out.println(option + " is not a valid option. Please, choose a number from 0 - 9");
                            break;
                    }
                }
        }
    }


