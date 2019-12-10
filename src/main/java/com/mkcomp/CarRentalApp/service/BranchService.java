package com.mkcomp.CarRentalApp.service;

import com.mkcomp.CarRentalApp.api.request.AddBranchRequest;
import com.mkcomp.CarRentalApp.model.Branch;

import java.util.List;

public interface BranchService {

    List<Branch> findAll();
    long addBranch(AddBranchRequest request);
    void deleteBranchById(long id);
    Branch getBranchById(long id);
}
