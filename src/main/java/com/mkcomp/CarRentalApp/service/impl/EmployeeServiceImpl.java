package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddEmployeeRequest;
import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.model.Employee;
import com.mkcomp.CarRentalApp.repository.BranchRepository;
import com.mkcomp.CarRentalApp.repository.EmployeeRepository;
import com.mkcomp.CarRentalApp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer class for CRUD operations on Employee objects
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    BranchRepository branchRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public Employee findEmployeeByUserNameAndPassword(LoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        return employeeRepository.findEmployeeByUserNameAndPassword(userName, password);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public long addEmployee(AddEmployeeRequest request) {
        Branch branch = extractBranchFromRepository(request.getBranchId());
        Employee employee = new Employee();
        employee.setBranch(branch);
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setPosition(request.getPosition());
        employee.setPassword(request.getPassword());
        employee.setUserName(request.getUserName());
        employee = employeeRepository.save(employee);
        return employee.getId();
    }

    private Branch extractBranchFromRepository(Long branchId) {
        Optional<Branch> optionalBranch = branchRepository.findById(branchId);
        if (!optionalBranch.isPresent()) {
            throw new IllegalArgumentException("There is no such a branch within database");
        }
        return optionalBranch.get();
    }
}
