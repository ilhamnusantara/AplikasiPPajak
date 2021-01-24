package com.example.perhitunganpajak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Button btPP, btInf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPP = findViewById(R.id.bPp);
        btInf = findViewById(R.id.bInform);

        btPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPerhitungan();
            }
        });

        btInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openInformasi();
            }
        });
    }
    public void openPerhitungan(){
        Intent i = new Intent(this,PerhitunganPajak.class);
        startActivity(i);
    }

    public void openInformasi(){
        Intent i = new Intent(this,InformasiPajak.class);
        startActivity(i);
    }
}