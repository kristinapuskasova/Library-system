package Borrowing;

import Customer.Customer;

import java.time.LocalDate;



public class Borrowing {

    private LocalDate dateOfBorrowing;


    public Borrowing(Customer borrower) {
        this.dateOfBorrowing = LocalDate.now();

    }


    public LocalDate getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public void setDateOfBorrowing(LocalDate dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

}


