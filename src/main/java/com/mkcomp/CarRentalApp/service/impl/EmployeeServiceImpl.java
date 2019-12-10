package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Employee;
import com.mkcomp.CarRentalApp.repository.EmployeeRepository;
import com.mkcomp.CarRentalApp.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findEmployeeByUserNameAndPassword(LoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        return employeeRepository.findEmployeeByUserNameAndPassword(userName, password);
    }
}
