package com.example.cekpajak.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.cekpajak.models.Tax;

public class TaxHelper extends Db{
    public static final String TABLE_NAME = "taxes";

    public static final String FOREIGN_TABLE = "users";
    public static final String KEY_ID = "id";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_TAX_NAME = "tax_name";
    public static final String KEY_BILLING_ID = "billing_id";
    public static final String KEY_NTPN = "ntpn";
    public static final String SQL_TABLE = " CREATE TABLE " + TABLE_NAME
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_ID + " INTEGER, "
            + KEY_TAX_NAME + " TEXT, "
            + KEY_BILLING_ID + " TEXT, "
            + KEY_NTPN + " TEXT,"
            + "FOREIGN KEY(" + KEY_USER_ID + ") REFERENCES " + FOREIGN_TABLE +"(" + KEY_ID +")"
            + " ) ";

    public TaxHelper(Context context) {
        super(context);
    }

    public void addTax(Tax tax) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_USER_ID, tax.user_id);
        values.put(KEY_TAX_NAME,tax.taxName);
        values.put(KEY_BILLING_ID, tax.billingID);
        values.put(KEY_NTPN, tax.ntpn);

        db.insert(TABLE_NAME, null, values);
    }
}
