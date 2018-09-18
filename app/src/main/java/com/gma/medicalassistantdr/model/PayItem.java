package com.gma.medicalassistantdr.model;

public class PayItem {
    private String mPayName;

    public PayItem(String a) {
        this.mPayName = a;
    }

    public String getPayName() {
        return this.mPayName;
    }

    public void setPayName(String a) {
        this.mPayName = a;
    }
}