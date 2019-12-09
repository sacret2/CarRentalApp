package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.repository.BranchRepository;
import com.mkcomp.CarRentalApp.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }
}
