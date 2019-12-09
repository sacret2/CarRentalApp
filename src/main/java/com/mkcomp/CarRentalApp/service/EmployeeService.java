package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.LoginRequest;
import com.mkcomp.CarRentalApp.model.Employee;

public interface EmployeeService {

    Employee findEmployeeByUserNameAndPassword(LoginRequest request);
}
