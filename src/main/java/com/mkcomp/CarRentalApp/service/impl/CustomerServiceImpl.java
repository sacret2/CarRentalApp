package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Address;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.repository.AddressRepository;
import com.mkcomp.CarRentalApp.repository.CustomerRepository;
import com.mkcomp.CarRentalApp.service.CustomerService;
import org.springframework.stereotype.Service;

/**
 * Service layer class defining CRUD operations on Customer objects
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private AddressRepository addressRepository;
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer findCustomerByUserNameAndPassword(LoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        return customerRepository.findCustomerByUserNameAndPassword(userName, password);
    }

    @Override
    public long addCustomer(AddCustomerRequest request) {
        Address address = addAddressToDataSource(request);
        Customer addedCustomer = addCustomerToDataSource(request, address);
        return addedCustomer.getId();
    }

    private Customer addCustomerToDataSource(AddCustomerRequest request, Address address){
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setEmail(request.getEmail());
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPassword(request.getPassword());
        customer.setUserName(request.getUserName());
        return customerRepository.save(customer);
    }

    private Address addAddressToDataSource(AddCustomerRequest request){
        Address address = new Address();
        address.setCity(request.getCity());
        address.setPostalCode(request.getPostalCode());
        address.setStreet(request.getStreet());
        address.setStreetNumber(request.getStreetNumber());
        return addressRepository.save(address);
    }
}
