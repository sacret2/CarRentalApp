package com.mkcomp.CarRentalApp.controller;


import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
            return "customerPanel";
        }
        return "index";
    }
}
