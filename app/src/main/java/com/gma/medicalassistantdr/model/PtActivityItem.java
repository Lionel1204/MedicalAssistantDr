package com.gma.medicalassistantdr.model;

public class PtActivityItem {
    private String mActivityName;

    public PtActivityItem(String a) {
        this.mActivityName = a;
    }

    public String getActivityName() {
        return this.mActivityName;
    }

    public void setActivityName(String a) {
        this.mActivityName = a;
    }
}
