package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Damage;
import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.*;
import com.mkcomp.CarRentalApp.service.DamageService;
import com.mkcomp.CarRentalApp.service.InvoiceService;
import com.mkcomp.CarRentalApp.service.RentalService;
import com.mkcomp.CarRentalApp.service.impl.BranchServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.CarServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.ReservationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private BranchServiceImpl branchService;
    private CarServiceImpl carService;
    private ReservationServiceImpl reservationService;
    private InvoiceService invoiceService;
    private RentalService rentalService;
    private DamageService damageService;
    private static Employee employee;

    public EmployeeController(BranchServiceImpl branchService, CarServiceImpl carService, ReservationServiceImpl reservationService, InvoiceService invoiceService, RentalService rentalService, DamageService damageService) {
        this.branchService = branchService;
        this.carService = carService;
        this.reservationService = reservationService;
        this.invoiceService = invoiceService;
        this.rentalService = rentalService;
        this.damageService = damageService;
    }

    @RequestMapping("/reservations")
    public String showReservations(Model model){
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        List<AddRentalRequest> addRentalRequests = new LinkedList<>();
        for(Reservation reservation : reservations){
            AddRentalRequest addRentalRequest = new AddRentalRequest();
            addRentalRequest.setReservation(reservation);
            addRentalRequests.add(addRentalRequest);
        }
        model.addAttribute("addRentalRequests", addRentalRequests);
        return "employee/reservations";
    }

    @RequestMapping("/reservations/createRental")
    public String showFormForRental(@RequestParam("addRentalRequest") AddRentalRequest addRentalRequest,
                                    Model model){
        model.addAttribute("addRentalRequest", addRentalRequest);
        return "employee/createRental";
    }

    @RequestMapping("/cars/addCar")
    public String addCarForm(Model model){
        AddCarRequest addCarRequest = new AddCarRequest();
        List<Branch> branches = branchService.findAll();
        model.addAttribute("addCarRequest", addCarRequest);
        model.addAttribute("branches", branches);
        return "employee/addCar";
    }

    @RequestMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "employee/cars";
    }

    @GetMapping("/cars/delete")
    public String deleteCar(@RequestParam("carId") long id){
        carService.deleteCarById(id);
        return "employee/panel";
    }

    @GetMapping("/cars/update")
    public String updateCar(@RequestParam("carId") long id, Model model){
        Car car = carService.findCarById(id);
        AddCarRequest addCarRequest = new AddCarRequest();
        addCarRequest.setBasePricePerDay(car.getBasePricePerDay());
        addCarRequest.setBrand(car.getBrand());
        addCarRequest.setModel(car.getModel());
        addCarRequest.setProductionYear(car.getProductionYear());
        addCarRequest.setSpecification(car.getSpecification());
        addCarRequest.setBranchId(car.getBranch().getId());
        carService.deleteCarById(car.getId());
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        model.addAttribute("addCarRequest", addCarRequest);
        return "employee/addCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("addCarRequest") AddCarRequest request){
        carService.addCar(request);
        return "employee/cars";
    }

    @RequestMapping("/")
    public String viewPanel() {
        return "employee/panel";
    }

    public static Employee getEmployee() {
        return employee;
    }

    @RequestMapping("/invoices")
    public String showInvoices(Model model){
        List<Invoice> invoices = invoiceService.findAll();
        model.addAttribute("cars", invoices);
        return "employee/invoices";
    }

    @RequestMapping("/rentals")
    public String showRentals(Model model){
        List<Rental> rentals = rentalService.getAllRentals();
        model.addAttribute("rentals", rentals);
        List<Damage> damages = new LinkedList<>();
        for(Rental rental : rentals){
            damages.add(rental.getDamage());
        }
        model.addAttribute("damages", damages);
        return "employee/rentals";
    }

    public static void setEmployee(Employee employee) {
        EmployeeController.employee = employee;
    }
}
