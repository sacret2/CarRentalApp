package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Invoice;

import java.util.List;

/**
 * Service layer class for CRUD operations on Invoice objects
 */
public interface InvoiceService {
    List<Invoice> findAll();
    long addInvoiceForRental(long rentalId);
    List<Invoice> findAllByCustomer(Customer customer);
}
