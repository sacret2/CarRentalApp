package com.mkcomp.CarRentalApp.repository;

import com.mkcomp.CarRentalApp.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
