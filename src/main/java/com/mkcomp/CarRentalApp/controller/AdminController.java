package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddCarRequest;
import com.mkcomp.CarRentalApp.api.request.AddEmployeeRequest;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Car;
import com.mkcomp.CarRentalApp.model.Employee;
import com.mkcomp.CarRentalApp.service.impl.BranchServiceImpl;
import com.mkcomp.CarRentalApp.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private BranchServiceImpl branchService;
    private EmployeeServiceImpl employeeService;

    public AdminController(BranchServiceImpl branchService, EmployeeServiceImpl employeeService) {
        this.branchService = branchService;
        this.employeeService = employeeService;
    }

    @RequestMapping("/employees")
    public String viewEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "admin/employees";
    }

    @RequestMapping("/panel")
    public String viewPanel(){
        return "admin/panel";
    }

    @RequestMapping("addEmployee")
    public String addEmployee(Model model){
        AddEmployeeRequest request = new AddEmployeeRequest();
        model.addAttribute("addEmployeeRequest", request);
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "admin/addEmployee";
    }

    @PostMapping("/employees/saveEmployee")
    public String saveEmployee(@ModelAttribute("addEmployeeRequest") AddEmployeeRequest request){
        employeeService.addEmployee(request);
        return "admin/panel";
    }

    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("employeeId") long id){
        employeeService.deleteEmployeeById(id);
        return "admin/panel";
    }

    @GetMapping("/employees/update")
    public String updateEmployee(@RequestParam("employeeId") long id, Model model){

        return "admin/addEmployee";
    }


}
