package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("theDate", new java.util.Date());

        return "index";
    }

    @RequestMapping("/login")
    public String viewLoginForm(Model model) {
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);
        return "login";
    }

    @RequestMapping("/register")
    public String viewRegisterForm(Model model) {
        AddCustomerRequest addCustomerRequest = new AddCustomerRequest();
        model.addAttribute("addCustomerRequest", addCustomerRequest);
        return "register";
    }



}
