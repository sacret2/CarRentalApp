package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.api.request.AddReservationRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Class used as controller for user of type "employee",
 * views directory: src/main/resources/templates/Employee/
 */
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
    private long carId;

    public EmployeeController(BranchServiceImpl branchService, CarServiceImpl carService, ReservationServiceImpl reservationService, InvoiceService invoiceService, RentalService rentalService, DamageService damageService) {
        this.branchService = branchService;
        this.carService = carService;
        this.reservationService = reservationService;
        this.invoiceService = invoiceService;
        this.rentalService = rentalService;
        this.damageService = damageService;
    }

    public static void setEmployee(Employee employee) {
        EmployeeController.employee = employee;
    }
    public static Employee getEmployee() {
        return employee;
    }

    @RequestMapping("/")
    public String viewPanel() {
        return "employee/panel";
    }

    // ============ CARS ============ BEG
    @RequestMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "employee/cars";
    }

    @RequestMapping("/addCar")
    public String addCarForm(Model model){
        AddCarRequest addCarRequest = new AddCarRequest();
        List<Branch> branches = branchService.findAll();
        model.addAttribute("addCarRequest", addCarRequest);
        model.addAttribute("branches", branches);
        return "employee/addCar";
    }

    @GetMapping("/deleteCar")
    public String deleteCar(@RequestParam("carId") long id){
        carService.deleteCarById(id);
        return "redirect:/employee/cars";
    }

    @GetMapping("/updateCar")
    public String updateCar(@RequestParam("carId") long id, Model model){
        Car car = carService.findCarById(id);
        AddCarRequest addCarRequest = new AddCarRequest();
        addCarRequest.setBasePricePerDay(car.getBasePricePerDay());
        addCarRequest.setBrand(car.getBrand());
        addCarRequest.setModel(car.getModel());
        addCarRequest.setProductionYear(car.getProductionYear());
        addCarRequest.setSpecification(car.getSpecification());
        addCarRequest.setBranchId(car.getBranch().getId());
        addCarRequest.setCarId(car.getId());
        List<Branch> branches = branchService.findAll();
        carId = car.getId();
        model.addAttribute("branches", branches);
        model.addAttribute("addCarRequest", addCarRequest);
        return "employee/updateCar";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("addCarRequest") AddCarRequest request){
        carService.addCar(request);
        return "redirect:/employee/cars";
    }

    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute("addCarRequest") AddCarRequest request){
        carService.updateCar(request, carId);
        return "redirect:/employee/cars";
    }
    // ============ CARS ============ END

    // ============ RESERVATIONS ============ BEG
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
    // ============ RESERVATIONS ============ END

    // ============ RENTALS ============ BEG
    @RequestMapping("/rentals")
    public String showRentals(Model model){
        List<Rental> rentals = rentalService.getAllRentals();
        for(Rental rental : rentals){
            rental.getReservation().getCar();
        }
        model.addAttribute("rentals", rentals);

        return "employee/rentals";
    }

    @RequestMapping("/createRental")
    public String showFormForRental(@RequestParam("reservationId") long reservationId,
                                    Model model
                                    ){
        AddRentalRequest addRentalRequest = new AddRentalRequest();
        Reservation reservation = reservationService.findById(reservationId);
        System.out.println(reservation);
        model.addAttribute("addRentalRequest", addRentalRequest);
        model.addAttribute("reservation", reservation);
        return "employee/createRental";
    }

    @PostMapping("/addRental")
    public String addNewRental(@ModelAttribute("addRentalRequest") AddRentalRequest request,
                               @ModelAttribute("reservation") Reservation reservation
                               ){
        System.out.println(reservation);
        rentalService.addRental(request, reservation);
        return "redirect:/employee/rentals";
    }

    @RequestMapping("/rental")
    public String showRental(@RequestParam("rentalId") long rentalId, Model model){
        Rental rental = rentalService.getRental(rentalId);
        model.addAttribute("rental", rental);
        return "employee/rental?rentalId";
    }
    // ============ RENTALS ============ END

    // ============ INVOICES ============ BEG
    @RequestMapping("/invoices")
    public String showInvoices(Model model){
        List<Invoice> invoices = invoiceService.findAll();
        for(Invoice invoice : invoices)
            invoice.getRental().getReservation().getCustomer();
        model.addAttribute("invoices", invoices);
        return "employee/invoices";
    }

    @RequestMapping("/generateInvoice")
    public String generateInvoice(@RequestParam("rentalId") long id){
        invoiceService.addInvoiceForRental(id);
        return "redirect:/employee/invoices";
    }
    // ============ INVOICES ============ END
}
