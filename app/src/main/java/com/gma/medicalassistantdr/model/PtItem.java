package com.gma.medicalassistantdr.model;

import android.media.Image;

public class PtItem {
    private String mName;
    private String mPtId;
    private String mPhone;
    private String mDrId;
    private Image mAvatar;


    public PtItem(String name, String ptId, String phone, String drId, Image avatar) {
        this.mName = name;
        this.mPtId = ptId;
        this.mPhone = phone;
        this.mDrId = drId;
        this.mAvatar = avatar;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String n) {
        this.mName = n;
    }

    public String getPtId() { return this.mPtId; }

    public void setPtId(String id) { this.mPtId = id; }

    public String getPhone() { return this.mPhone; }

    public void setPhone(String phone) { this.mPhone = phone; }

    public String getDrId() { return this.mDrId; }

    public void setDrId(String id) { this.mDrId = id; }

    public Image getAvatar() { return this.mAvatar; }

    public void setAvatar(Image avatar) { this.mAvatar = avatar; }
}
