package com.example.cekpajak.models;

public class Tax {
    public int id;
    public int user_id;
    public String taxName;
    public String taxAmount;
    public String billingID;
    public String ntpn;

    public Tax(int id,int user_id, String taxName, String taxAmount, String billingID, String ntpn) {
        this.id = id;
        this.user_id = user_id;
        this.taxName = taxName;
        this.taxAmount = taxAmount;
        this.billingID = billingID;
        this.ntpn = ntpn;
    }
}
