package com.example.cekpajak.models;

public class Tax {
    public String id;
    public int user_id;
    public String taxName;
    public float taxAmount;
    public String billingID;
    public String ntpn;

    public Tax(String id, int user_id, String taxName, String billingID, String ntpn,float taxAmount) {
        this.id = id;
        this.user_id = user_id;
        this.taxName = taxName;
        this.billingID = billingID;
        this.ntpn = ntpn;
        this.taxAmount = taxAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public float getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(float taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getBillingID() {
        return billingID;
    }

    public void setBillingID(String billingID) {
        this.billingID = billingID;
    }

    public String getNtpn() {
        return ntpn;
    }

    public void setNtpn(String ntpn) {
        this.ntpn = ntpn;
    }


}
