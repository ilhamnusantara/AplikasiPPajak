package com.example.cekpajak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.cekpajak.R;

import java.text.DecimalFormat;

public class Pph21Golongan extends AppCompatActivity {
    private Button bGol, bGol3, bGol4, nonPns;
    private TextView nHasil, nPotongan, Nominal, tPot, tHas;
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
        tPot = findViewById(R.id.tPot);
        tHas = findViewById(R.id.tHas);
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
                tPot.setText("Jumlah Potongan Honor Gol I/II");
                tHas.setText("Jumlah Bersih yang diterima Gol I/II ");
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
                tPot.setText("Jumlah Potongan Honor Gol III");
                tHas.setText("Jumlah Bersih yang diterima Gol III ");
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
                tPot.setText("Jumlah Potongan Honor Gol IV");
                tHas.setText("Jumlah Bersih yang diterima Gol IV ");
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
                tPot.setText("Jumlah Potongan Honor non ASN");
                tHas.setText("Jumlah Bersih yang diterima non ASN ");
            }
        });

    }
}