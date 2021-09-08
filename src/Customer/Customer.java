package Customer;

import Book.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    Scanner scanner = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private Address address;
    private ArrayList<Book> booksBorrowedByCustomer = new ArrayList<>();

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Book> getBooksBorrowedByCustomer() {
        return booksBorrowedByCustomer;
    }

    public static class Address {

        private String streetName;
        private int streetNumber;
        private String city;
        private String country;

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public void setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        private Address() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Street: ");
            this.streetName = scanner.nextLine();
            System.out.print("Street number: ");
            this.streetNumber = Integer.parseInt(scanner.nextLine());
            System.out.print("City: ");
            this.city = scanner.nextLine();
            System.out.print("Country: ");
            this.country = scanner.nextLine();

        }

        public Address(String streetName, int streetNumber, String city, String country) {
            this.streetName = streetName;
            this.streetNumber = streetNumber;
            this.city = city;
            this.country = country;
        }

        @Override
        public String toString() {
            return "Address: \nStreet Name: " + streetName + "\nStreet Number: " + streetNumber + "\nCity: " + city + "\nCountry: " + country;
        }
    }

    public Customer() {
        System.out.print("First Name: ");
        this.firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        this.lastName = scanner.nextLine();
        System.out.print("Address: \n");
        this.address = new Address();
    }

    public Customer(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }



    @Override
    public String toString() {
        String s = "First Name: " + this.firstName + "\n" + "Last Name: " + this.lastName + "\n\n" + this.address;
        return s;
    }
}
