package com.example.cekpajak.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Db extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "cekpajak";
    public static final int DATABASE_VERSION = 4;

    public Db(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserHelper.SQL_TABLE);
        sqLiteDatabase.execSQL(TaxHelper.SQL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + UserHelper.TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TaxHelper.TABLE_NAME);
    }



}
