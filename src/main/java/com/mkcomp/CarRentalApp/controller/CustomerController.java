package com.mkcomp.CarRentalApp.controller;


import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.api.request.AddReservationRequest;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Customer;
import com.mkcomp.CarRentalApp.model.Invoice;
import com.mkcomp.CarRentalApp.repository.CarRepository;
import com.mkcomp.CarRentalApp.service.CustomerService;
import com.mkcomp.CarRentalApp.service.impl.BranchServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.CarServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.CustomerServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.ReservationServiceImpl;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.InlineView;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceImpl customerService;
    private BranchServiceImpl branchService;
    private CarServiceImpl carService;
    private ReservationServiceImpl reservationService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService,
                              BranchServiceImpl branchService,
                              CarServiceImpl carService,
                              ReservationServiceImpl reservationService) {
        this.customerService = customerService;
        this.branchService = branchService;
        this.carService = carService;
        this.reservationService = reservationService;
    }

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

    @RequestMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "customer/cars";
    }

    @RequestMapping("/createReservation")
    public String createReservation(@RequestParam("AddReservationRequest") AddReservationRequest addReservationRequest,
                                    @RequestParam("CarId") long carId){
        Car car = carService.findCarById(carId);
        addReservationRequest.setCar(car);
        reservationService.addReservation(addReservationRequest);
        return "customer/reservations";
    }

}
