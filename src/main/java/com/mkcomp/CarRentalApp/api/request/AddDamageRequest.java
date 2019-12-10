package com.mkcomp.CarRentalApp.api.request;

public class AddDamageRequest {

    private String description;
    private double damagePenalty;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDamagePenalty() {
        return damagePenalty;
    }

    public void setDamagePenalty(double damagePenalty) {
        this.damagePenalty = damagePenalty;
    }
}
