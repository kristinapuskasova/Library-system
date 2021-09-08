import Book.Book;
import Book.ScientificBook;
import Book.ForeignBook;
import Customer.Customer;
import Customer.Customer.Address;
import Customer.CustomerManager;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Library myLibrary = new Library();
        CustomerManager customerManager = new CustomerManager();


        Book book1 = new Book("Alice", "Lewis Caroll", 200);
        Book book2 = new ScientificBook("History", "Stephen Hawking", 256, "Cosmology");
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

        System.out.println("Welcome to the Library!");
        System.out.println("Choose one of the following options (0-9): ");
        System.out.println("0: Exit application \n1: Add a new book to the Library\n2: Remove a book from the Library\n3: List all books in the Library\n4: List all books available for borrowing\n5: Borrow a book\n6: Return a book\n7: Add a new customer\n8: Update address\n9: List all customers\n");

        //odtial uz nemazat

        int exitNum = 1;

        while (exitNum != 0) {
            System.out.print("Your choice: ");
            int option = scanner.nextInt();


            switch (option) {
                case 0 : exitNum = 0; break;

                case 1: //add book
                    System.out.println("ADD BOOK\n");
                    System.out.print("Select one of the following Book Types: \n1: standard\n2: scientific\n3: foreign\n\nSelected Book Type: ");
                    int bookType = scanner.nextInt();

                    switch (bookType) {
                        case 1:
                            Book standardBook = new Book();
                            myLibrary.addNewBook(standardBook);
                            System.out.println("You've just added " + standardBook.getTitle() + " to the Library!\n");
                            break;

                        case 2:
                            Book scientificBook = new ScientificBook();
                            myLibrary.addNewBook(scientificBook);
                            System.out.println("You've just added " + scientificBook.getTitle() + " to the Library!\n");
                            break;

                        case 3:
                            Book foreignBook = new ForeignBook();
                            myLibrary.addNewBook(foreignBook);
                            System.out.println("You've just added " + foreignBook.getTitle() + " to the Library!\n");
                            break;
                    }
                    break;

                case 2: //remove book
                    System.out.println("REMOVE BOOK\n");
                    System.out.print("Enter title of the book you wish to remove: ");
                    String s = scanner.next();
                    for (int i = 0; i < myLibrary.getListOfAllBooks().size(); i++) {
                        if (myLibrary.getListOfAllBooks().get(i).getTitle().toLowerCase().equals(s.toLowerCase())) {
                            System.out.println("Hurray");
                            myLibrary.removeBook(myLibrary.getListOfAllBooks().get(i));
                            break;
                        } else {
                            System.out.println("Nooooooooooo");
                        }
                    }
                    break;
//                    System.out.print("Remove book No.: ");
//                    int bookNo = scanner.nextInt();
//                    int bookIndex = bookNo - 1;
//                    myLibrary.getListOfBooksAvailable().remove(bookIndex);
//                    myLibrary.getListOfAllBooks().remove(bookIndex);
//                    System.out.println("You've removed Book No.: " + bookNo + " from the Library");
//                    break;

                case 3: //show list of all books
                    System.out.println("LIST OF ALL BOOKS\n");
                    for (int i = 1; i <= myLibrary.getListOfAllBooks().size(); i++) {
                        System.out.println("Book No. " + i + ":\n" + myLibrary.getListOfAllBooks().get(i-1).toString() + "\n");
                    }
                    break;

                case 4: //list books available for borrowing
                    System.out.println("LIST OF AVAILABLE BOOKS\n");
                    for (int i = 1; i <= myLibrary.getListOfBooksAvailable().size(); i++) {
                        System.out.println("Book No. " + i + ":\n" + myLibrary.getListOfBooksAvailable().get(i-1).toString() + "\n");
                    }
                    break;

                case 5: //borrow a book
                    System.out.println("BORROW BOOK\n");
                    System.out.print("Borrow book No.: ");
                    int bookToBeBorrowed = scanner.nextInt();
                    int bookToBeBorrowedIndex = bookToBeBorrowed - 1;
                    System.out.println("Borrowed by customer No.: ");
                    int borrowingCustomer = scanner.nextInt();
                    int borrowingCustomerIndex = borrowingCustomer - 1;
                    myLibrary.borrowBook(myLibrary.getListOfBooksAvailable().get(bookToBeBorrowedIndex), customerManager.getListOfCustomers().get(borrowingCustomerIndex));
                    System.out.println("Book No. " + bookToBeBorrowed + " has been borrowed by customer No. " + borrowingCustomer + "\n");
                    break;

                case 6: //return a book
                    System.out.println("RETURN BOOK\n");
                    System.out.println("List of borrowed books:\n");
                    for (int i = 1; i <= myLibrary.getListOfBorrowedBooks().size(); i++) {
                        System.out.println("Book No. " + i + ":\n" + myLibrary.getListOfBorrowedBooks().get(i-1).toString() + "\n");
                    }
                    System.out.println("Select the book you wish to return:\n");
                    int bookToBeReturned = scanner.nextInt();
                    int bookToBeReturnedIndex = bookToBeReturned - 1;

                    System.out.println("List of customers:\n");
                    for (int i = 1; i <= customerManager.getListOfCustomers().size(); i++) {
                        System.out.println("Customer No. " + i + ":\n" + customerManager.getListOfCustomers().get(i-1).toString() + "\n");
                    }
                    System.out.println("Select customer:\n");
                    int returningCustomer = scanner.nextInt();
                    int returningCustomerIndex = returningCustomer - 1;

                    myLibrary.returnBook(myLibrary.getListOfBorrowedBooks().get(bookToBeReturnedIndex), customerManager.getListOfCustomers().get(returningCustomerIndex));
                    System.out.println("Customer No. " + returningCustomer + " has returned Book No. " + bookToBeReturned);
                    break;

                case 7: //add new customer
                    System.out.println("ADD CUSTOMER\n");
                    Customer customer = new Customer();
                    customerManager.addNewCustomer(customer);
                    break;

                case 8:
                    System.out.println("UPDATE ADDRESS\n");
                    System.out.print("Change the address of customer No.: ");
                    int customerNo = scanner.nextInt();
                    int customerIndex = customerNo - 1;

                    System.out.print("New Street Name: ");
                    String newStreetName = scanner.next();
                    customerManager.getListOfCustomers().get(customerIndex).getAddress().setStreetName(newStreetName);

                    System.out.print("New Street Number: ");
                    int newStreetNumber = scanner.nextInt();
                    customerManager.getListOfCustomers().get(customerIndex).getAddress().setStreetNumber(newStreetNumber);

                    System.out.print("New City: ");
                    String newCity = scanner.nextLine();
                    customerManager.getListOfCustomers().get(customerIndex).getAddress().setCity(newCity);

                    System.out.print("New Country: ");
                    String newCountry = scanner.nextLine();
                    customerManager.getListOfCustomers().get(customerIndex).getAddress().setCountry(newCountry);
                    break;

                case 9: //show list of all customers
                    System.out.println("LIST OF ALL CUSTOMERS\n");
                    for (int i = 1; i <= customerManager.getListOfCustomers().size(); i++) {
                        System.out.println("Customer No. " + i + ":\n" + customerManager.getListOfCustomers().get(i-1).toString() + "\n");
                    }
                    break;

            }
        }
    }


}