package com.mkcomp.CarRentalApp.controller;


import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.repository.CarRepository;
import com.mkcomp.CarRentalApp.service.CustomerService;
import com.mkcomp.CarRentalApp.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("addCustomerRequest")AddCustomerRequest request, Model model) {
        long customerId = customerService.addCustomer(request);
        if (customerId != -1) {
            Customer customer = customerService.findCustomerById(customerId);
            model.addAttribute("customer", customer);
            return "/customer/panel";
        }
        return "index";
    }


}
