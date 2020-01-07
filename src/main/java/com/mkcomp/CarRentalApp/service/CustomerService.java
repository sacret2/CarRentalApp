package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Customer;

/**
 * Service layer interface declaring CRUD operations on Customer objects
 */
public interface CustomerService {

    long addCustomer(AddCustomerRequest request);
    Customer findCustomerById(long id);
    Customer findCustomerByUserNameAndPassword(LoginRequest request);
}
