package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.api.request.AddDamageRequest;
import com.mkcomp.CarRentalApp.api.request.AddRentalRequest;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Reservation;
import com.mkcomp.CarRentalApp.service.ReservationService;
import com.mkcomp.CarRentalApp.service.impl.BranchServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.CarServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.ReservationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private BranchServiceImpl branchService;
    private CarServiceImpl carService;
    private ReservationServiceImpl reservationService;

    public EmployeeController(BranchServiceImpl branchService, CarServiceImpl carService) {
        this.branchService = branchService;
        this.carService = carService;
    }

    @RequestMapping("/reservations")
    public String showReservations(Model model){
        List<Reservation> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "employee/reservations";
    }

    @PostMapping("/reservations/createRental")
    public String showFormForRental(@RequestParam("reservationId") long id, Model model){
        Reservation reservation = reservationService.findById(id);
        AddDamageRequest addDamageRequest = new AddDamageRequest();
        model.addAttribute("addDamageRequest", addDamageRequest);
        AddRentalRequest addRentalRequest = new AddRentalRequest();
        addRentalRequest.setDamageRequest(addDamageRequest);
        addRentalRequest.setReservation(reservation);
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
        return "employee/panel";
    }

    @RequestMapping("/")
    public String viewPanel() {
        return "employee/panel";
    }


}
