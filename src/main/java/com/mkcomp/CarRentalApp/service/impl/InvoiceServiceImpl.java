package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Invoice;
import com.mkcomp.CarRentalApp.model.Rental;
import com.mkcomp.CarRentalApp.repository.InvoiceRepository;
import com.mkcomp.CarRentalApp.repository.RentalRepository;
import com.mkcomp.CarRentalApp.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Service layer class for CRUD operations on Invoice objects
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {
    InvoiceRepository invoiceRepository;
    RentalRepository rentalRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, RentalRepository rentalRepository) {
        this.invoiceRepository = invoiceRepository;
        this.rentalRepository = rentalRepository;
    }

    @Override
    public long addInvoiceForRental(long rentalId) {
        Rental rental = rentalRepository.getOne(rentalId);
        Invoice invoice = new Invoice();
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setRental(rental);
        return invoiceRepository.save(invoice).getId();
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> findAllByCustomer(Customer customer) {
        List<Invoice> allInvoices = invoiceRepository.findAll();
        List<Invoice> customerInvoices = new ArrayList<>();
        for (Invoice inv : allInvoices){
            if (inv.getRental().getReservation().getCustomer().getId() == customer.getId()) customerInvoices.add(inv);
        }
        return customerInvoices;
    }
}
