package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.service.impl.BranchServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.CarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/employee")
public class EmployeeController {
    private BranchServiceImpl branchService;
    private CarServiceImpl carService;

    public EmployeeController(BranchServiceImpl branchServiceImpl, CarServiceImpl carService) {
        this.branchService = branchService;
        this.carService = carService;
    }

    @RequestMapping("/addCar")
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

    @DeleteMapping("cars/delete")
    public String deleteCar(@RequestParam("carId") long id){
        carService.deleteCarById(id);
        return "employee/cars";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("addCarRequest") AddCarRequest request){
        carService.addCar(request);
        return "employee/panel";
    }


}
