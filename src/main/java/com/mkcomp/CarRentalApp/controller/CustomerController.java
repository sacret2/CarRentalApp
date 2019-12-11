package com.mkcomp.CarRentalApp.controller;


import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.api.request.AddReservationRequest;
import com.mkcomp.CarRentalApp.model.*;
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
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.InlineView;

import java.time.Duration;
import java.time.LocalDateTime;

import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerServiceImpl customerService;
    private BranchServiceImpl branchService;
    private CarServiceImpl carService;
    private ReservationServiceImpl reservationService;
    private Reservation reservation;

    private static Customer customer;

    public static Customer getCustomer() {
        return customer;
    }

    public static void setCustomer(Customer customer) {
        CustomerController.customer = customer;
    }

    public CustomerController(CustomerServiceImpl customerService,
                              BranchServiceImpl branchService,
                              CarServiceImpl carService,
                              ReservationServiceImpl reservationService) {
        this.customerService = customerService;
        this.branchService = branchService;
        this.carService = carService;
        this.reservationService = reservationService;
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
        Customer customer = (Customer) model.getAttribute("user");
        List<AddReservationRequest> addReservationRequests = new LinkedList<>();
        for(Car car: cars){
            addReservationRequests.add(new AddReservationRequest(car, customer));
        }
        model.addAttribute("addReservationRequests", addReservationRequests);
        return "customer/cars";
    }

    @RequestMapping("/findCars")
    public String findCars(Model model){
        AddReservationRequest request = new AddReservationRequest();
        model.addAttribute("addReservationRequest", request);
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "customer/findCars";
    }

    @GetMapping("/availableCars")
    public String showFoundCars(@ModelAttribute("addReservationRequest") AddReservationRequest request, Model model){

        LocalDateTime start = request.getReservationStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = request.getReservationEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        reservation = new Reservation();
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setCustomer(customer);
        reservation.setReservationStart(start);
        reservation.setReservationEnd(end);
        List<Car> availableCars = carService.findAvailableCars(start, end, request.getBranchId());
        String city = branchService.getBranchById(request.getBranchId()).getAddress().getCity();
        long numOfDays = Duration.between(start,end).toDays();
        model.addAttribute("addReservationRequest", request);
        model.addAttribute("availableCars", availableCars);
        model.addAttribute("city", city);
        model.addAttribute("days", numOfDays);
        return "customer/availableCars";
    }

    @RequestMapping("/panel")
    public String viewPanel() {
        return "customer/panel";
    }

    @RequestMapping("/reservations")
    public String viewReservations(Model model){
        List<Reservation> reservations = reservationService.findReservationsByCustomer(customer);
        model.addAttribute("reservations", reservations);

        return "customer/reservations";
    }


    @RequestMapping("/availableCars/createReservation")
    public String createReservation(@RequestParam("carId") long carId,
                                    Model model){
        reservation.setCar(carService.findCarById(carId));
        long numOfDays = Duration.between(reservation.getReservationStart(),reservation.getReservationEnd()).toDays();
        double cost = reservation.getCar().getBasePricePerDay() * numOfDays;
        reservation.setCost(cost);
        reservationService.addReservation(reservation);
        List<Reservation> reservations = reservationService.findReservationsByCustomer(customer);
        model.addAttribute("reservations", reservations);
        return "customer/reservations";
    }

}
