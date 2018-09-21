package com.gma.medicalassistantdr.model;

import android.graphics.Bitmap;

public class DrItem {
    private String mName;
    private Bitmap mAvatar;

    public DrItem(String t, Bitmap a) {
        this.mName = t;
        this.mAvatar = a;
    }

    public String getItemName() {
        return this.mName;
    }

    public void setItemName(String t) {
        this.mName = t;
    }

    public Bitmap getAvatar() {
        return this.mAvatar;
    }

    public void setAvatar(Bitmap a) {
        this.mAvatar = a;
    }
}
