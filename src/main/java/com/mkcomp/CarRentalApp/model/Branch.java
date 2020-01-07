package com.mkcomp.CarRentalApp.model;


import javax.persistence.*;
import java.util.List;

/**
 * Class representing company branch
 */
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL )
    List<Employee> employees;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    List<Car> cars;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
