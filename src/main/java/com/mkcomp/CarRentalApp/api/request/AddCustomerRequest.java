package com.mkcomp.CarRentalApp.api.request;

import com.mkcomp.CarRentalApp.model.Address;


public class AddCustomerRequest {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String postalCode;
    private String street;
    private String city;
    private String streetNumber;

    public AddCustomerRequest() {
    }

    public AddCustomerRequest(String firstName, String lastName, String userName, String password, String email, String postalCode, String street, String city, String streetNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.postalCode = postalCode;
        this.street = street;
        this.city = city;
        this.streetNumber = streetNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
