package com.mkcomp.CarRentalApp.service.impl;

import com.mkcomp.CarRentalApp.api.request.AddBranchRequest;
import com.mkcomp.CarRentalApp.api.request.AddCustomerRequest;
import com.mkcomp.CarRentalApp.model.Address;
import com.mkcomp.CarRentalApp.model.Branch;
import com.mkcomp.CarRentalApp.repository.AddressRepository;
import com.mkcomp.CarRentalApp.repository.BranchRepository;
import com.mkcomp.CarRentalApp.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer class for CRUD operations on Branch and Adress objects
 */
@Service
public class BranchServiceImpl implements BranchService {
    BranchRepository branchRepository;
    AddressRepository addressRepository;

    public BranchServiceImpl(BranchRepository branchRepository, AddressRepository addressRepository) {
        this.branchRepository = branchRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public long addBranch(AddBranchRequest request) {
        Address address = addAddressToDataSource(request);
        Branch branch = new Branch();
        branch.setAddress(address);
        branch = branchRepository.save(branch);
        return branch.getId();
    }

    private Address addAddressToDataSource(AddBranchRequest request){
        Address address = new Address();
        address.setCity(request.getCity());
        address.setPostalCode(request.getPostalCode());
        address.setStreet(request.getStreet());
        address.setStreetNumber(request.getStreetNumber());
        return addressRepository.save(address);
    }

    @Override
    public void deleteBranchById(long id) {
        branchRepository.deleteById(id);
    }

    @Override
    public Branch getBranchById(long id) {
        return branchRepository.getOne(id);
    }
}
