package com.mkcomp.CarRentalApp.controller;

import com.mkcomp.CarRentalApp.api.request.AddEmployeeRequest;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.service.impl.BranchServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    BranchServiceImpl branchService;

    public AdminController(BranchServiceImpl branchService) {
        this.branchService = branchService;
    }

    @RequestMapping("addEmployee")
    public String addEmployee(Model model){
        AddEmployeeRequest request = new AddEmployeeRequest();
        model.addAttribute("addEmployeeRequest", request);
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "admin/addEmployee";
    }


}
