package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddEmployeeRequest;
import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Employee;

import java.util.List;

/**
 * Service layer class for CRUD operations on Employee objects
 */
public interface EmployeeService {

    Employee findEmployeeByUserNameAndPassword(LoginRequest request);
    List<Employee> findAll();
    void deleteEmployeeById(long employeeId);
    long addEmployee(AddEmployeeRequest request);
    Employee getEmployeeById(long id);
}
