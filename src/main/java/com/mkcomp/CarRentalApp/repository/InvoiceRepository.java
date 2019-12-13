package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface between Postgres database and application logic declaring CRUD methods for Invoice objects
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
