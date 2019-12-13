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

import java.util.LinkedList;
import java.util.List;

/**
 * Class used as controller for .html files under src/main/resources/templates/Employee/
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

    @RequestMapping("/createRental")
    public String showFormForRental(@RequestParam("reservationId") long reservationId,
                                    Model model){
        AddRentalRequest addRentalRequest = new AddRentalRequest();
        addRentalRequest.setReservation(reservationService.findById(reservationId));
        model.addAttribute("addRentalRequest", addRentalRequest);
        return "employee/createRental";
    }

    @RequestMapping("/rental")
    public String showRental(@RequestParam("rentalId") long rentalId, Model model){
        Rental rental = rentalService.getRental(rentalId);
        model.addAttribute("rental", rental);
        return "employee/rental?rentalId";
    }

    @PostMapping("rentals/add")
    public String addNewRental(@ModelAttribute("addRentalRequest") AddRentalRequest request){
        rentalService.addRental(request);
        return "employee/panel";
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
        return "employee/panel";
    }

    @PostMapping("/updateCar")
    public String updateCar(@ModelAttribute("addCarRequest") AddCarRequest request){
        carService.updateCar(request, carId);
        return "employee/panel";
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
        model.addAttribute("invoices", invoices);
        return "employee/invoices";
    }

    @RequestMapping("/rentals")
    public String showRentals(Model model){
        List<Rental> rentals = rentalService.getAllRentals();
        model.addAttribute("rentals", rentals);
//        List<Damage> damages = new LinkedList<>();
//        for(Rental rental : rentals){
//            damages.add(rental.getDamage());
//        }
//        model.addAttribute("damages", damages);
        return "employee/rentals";
    }

    @RequestMapping("/generateInvoice")
    public String generateInvoice(@RequestParam("rentalId") long id){
        invoiceService.addInvoiceForRental(id);
        return "employee/panel";
    }

    @RequestMapping("/panel")
    public String showPanel(){
        return "employee/panel";
    }

    public static void setEmployee(Employee employee) {
        EmployeeController.employee = employee;
    }
}
