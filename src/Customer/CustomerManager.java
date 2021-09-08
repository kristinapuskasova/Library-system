package Customer;

import Book.Book;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerManager {

    private ArrayList<Customer> listOfCustomers;

    public ArrayList<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public CustomerManager() {
        this.listOfCustomers = new ArrayList<>();
    }

    public void addNewCustomer(Customer customer) {
        this.listOfCustomers.add(customer);
    }
}

