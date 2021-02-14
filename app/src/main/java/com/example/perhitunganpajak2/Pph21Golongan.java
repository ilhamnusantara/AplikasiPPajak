package com.example.perhitunganpajak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class Pph21Golongan extends AppCompatActivity {
    private Button bGol, bGol3, bGol4, nonPns;
    private TextView nHasil, nPotongan, Nominal;
    double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pph21_golongan);
        Intent i = getIntent();
        double bawa = Double.parseDouble(i.getStringExtra("nominal"));
        bGol = findViewById(R.id.bGol1);
        bGol3 = findViewById(R.id.bGol3);
        bGol4 = findViewById(R.id.bGol4);
        nonPns = findViewById(R.id.nonPns);
        Nominal = findViewById(R.id.nHonor);
        nHasil = findViewById(R.id.nHasil);
        nPotongan = findViewById(R.id.nPotangan);

        DecimalFormat df = new DecimalFormat("#,###,###");
        Nominal.setText(""+df.format(bawa));



        bGol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = bawa * 0 / 100;
                c = bawa-b;
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });

        bGol3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = bawa * 5 / 100;
                c = bawa-b;
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });

        bGol4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = bawa * 15 / 100;
                c = bawa-b;
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });

        nonPns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = bawa * 5 / 100;
                c = bawa-b;
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });

    }
}