package com.example.cekpajak.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.cekpajak.R;
import com.example.cekpajak.helpers.Db;
import com.example.cekpajak.helpers.TaxHelper;
import com.example.cekpajak.helpers.UserHelper;
import com.example.cekpajak.models.Tax;

import java.util.ArrayList;

public class NtpnActivity extends AppCompatActivity {
    private TaxHelper taxHelper;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList taxList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntpn);

        taxList = new ArrayList<>();
        taxHelper = new TaxHelper(this);
        recyclerView = findViewById(R.id.rvData);
        getData();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RvAdapter(taxList);
        Log.d("ARRAYlIST:",String.valueOf(taxList.size()));

        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
    }

    protected void getData() {
        //Mengambil Repository dengan Mode Membaca
        SQLiteDatabase ReadData = taxHelper.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM " + TaxHelper.TABLE_NAME, null);

        cursor.moveToFirst();//Memulai Cursor pada Posisi Awal

        //Melooping Sesuai Dengan Jumlan Data (Count) pada cursor
        for (int count = 0; count < cursor.getCount(); count++) {
            Log.d("COUNT:",String.valueOf(count));
            cursor.moveToPosition(count);//Berpindah Posisi dari no index 0 hingga no index terakhir
            Tax tax = new Tax(cursor.getString(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getFloat(5));
            taxList.add(tax);
        }
    }
}