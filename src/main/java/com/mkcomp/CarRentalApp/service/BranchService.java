package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddBranchRequest;
import com.mkcomp.CarRentalApp.model.Branch;

import java.util.List;

/**
 * Service layer interface declaring CRUD operations on Branch and Adress objects
 */
public interface BranchService {

    List<Branch> findAll();
    long addBranch(AddBranchRequest request);
    void deleteBranchById(long id);
    Branch getBranchById(long id);
}
