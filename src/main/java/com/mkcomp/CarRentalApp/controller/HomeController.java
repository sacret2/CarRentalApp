package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Employee;
import com.mkcomp.CarRentalApp.service.CustomerService;
import com.mkcomp.CarRentalApp.service.EmployeeService;
import com.mkcomp.CarRentalApp.service.impl.CustomerServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    CustomerServiceImpl customerService;
    EmployeeServiceImpl employeeService;

    public HomeController(CustomerServiceImpl customerService, EmployeeServiceImpl employeeService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("theDate", new java.util.Date());

        return "index";
    }

    @RequestMapping("/loginForm")
    public String viewLoginForm(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "loginForm";
    }

    @RequestMapping("/register")
    public String viewRegisterForm(Model model) {
        AddCustomerRequest addCustomerRequest = new AddCustomerRequest();
        model.addAttribute("addCustomerRequest", addCustomerRequest);
        return "register";
    }

    @GetMapping("/login")
    public String loginUser(@ModelAttribute("loginRequest") LoginRequest request, Model model) {
        Employee employee = employeeService.findEmployeeByUserNameAndPassword(request);
        if (employee != null) {
            model.addAttribute("user", employee);
            if (employee.isAdmin()) return "admin/panel";
            return "employee/panel";
        }
        Customer customer = customerService.findCustomerByUserNameAndPassword(request);
        if (customer != null) {
            CustomerController.customer = customer;
            model.addAttribute("user", customer);
            return "customer/panel";
        }
        return "invalid-login";
    }




}
