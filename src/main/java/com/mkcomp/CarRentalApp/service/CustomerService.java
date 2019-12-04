package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;

public interface CustomerService {

    long addCustomer(AddCustomerRequest request);
}
