package com.gma.medicalassistantdr.model;

import android.media.Image;

public class DrItem {
    private String mName;
    private Image mAvatar;

    public DrItem(String t, Image a) {
        this.mName = t;
        this.mAvatar = a;
    }

    public String getItemName() {
        return this.mName;
    }

    public void setItemName(String t) {
        this.mName = t;
    }

    public Image getAvatar() {
        return this.mAvatar;
    }

    public void setAvatar(Image a) {
        this.mAvatar = a;
    }
}
