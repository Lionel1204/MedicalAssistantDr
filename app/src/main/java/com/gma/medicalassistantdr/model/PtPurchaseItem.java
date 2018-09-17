package com.gma.medicalassistantdr.model;

public class PtPurchaseItem {
    private String mProductName;
    private String mProgress;

    public PtPurchaseItem(String n, String p) {
        this.mProductName = n;
        this.mProgress = p;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public void setProductName(String t) {
        this.mProductName = t;
    }

    public String getProgress() {
        return this.mProgress;
    }

    public void setProgress(String p) { this.mProgress = p; }
}
