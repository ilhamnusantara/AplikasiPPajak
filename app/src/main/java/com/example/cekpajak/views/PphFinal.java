package com.example.cekpajak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.perhitunganpajak2.R;

import java.text.DecimalFormat;

public class PphFinal extends AppCompatActivity {
    private TextView tPelKons, tKonsultan, nPajak, nBPajak, tSewa, tUndian;
    private Button bPel1, bPel2, bPel3, bKon1, bKon2, bSewa, bUndian;
    private double a, bawa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pph_final);
        Intent i = getIntent();
        bawa = Double.parseDouble(i.getStringExtra("nominal"));
        tPelKons = findViewById(R.id.tPelKons);
        tKonsultan = findViewById(R.id.tKonsul);
        tSewa = findViewById(R.id.tSTanah);
        tUndian = findViewById(R.id.tHUndian);
        nPajak = findViewById(R.id.nPajak);
        bPel1 = findViewById(R.id.bPel1);
        bPel2 = findViewById(R.id.bPel2);
        bPel3 = findViewById(R.id.bPel3);
        bKon1 = findViewById(R.id.bKon1);
        bKon2 = findViewById(R.id.bKon2);
        bSewa = findViewById(R.id.bSewa);
        bUndian = findViewById(R.id.bUndian);
        nBPajak = findViewById(R.id.nBPajak);

        DecimalFormat df = new DecimalFormat("#,###,###");
        nPajak.setText(""+df.format(bawa));

        tPelKons.setPaintFlags(tPelKons.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        tKonsultan.setPaintFlags(tKonsultan.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        tSewa.setPaintFlags(tSewa.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tUndian.setPaintFlags(tUndian.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        bPel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 2 / 100;
                nBPajak.setText(""+df.format(a));
            }
        });

        bPel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 3 /100;
                nBPajak.setText(""+df.format(a));
            }
        });

        bPel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 4 / 100;
                nBPajak.setText(""+df.format(a));
            }
        });

        bKon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 4 / 100;
                nBPajak.setText(""+df.format(a));
            }
        });

        bKon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 6 / 100;
                nBPajak.setText(""+df.format(a));
            }
        });

        bSewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 6 / 100;
                nBPajak.setText(""+df.format(a));
            }
        });

        bUndian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("#,###,###.##");
                a = bawa * 25 / 100;
                nBPajak.setText(""+df.format(a));
            }
        });
    }
}

