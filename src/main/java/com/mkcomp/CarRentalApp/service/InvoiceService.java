package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();
    long addInvoiceForRental(long rentalId);
    List<Invoice> findAllByCustomer(Customer customer);
}
