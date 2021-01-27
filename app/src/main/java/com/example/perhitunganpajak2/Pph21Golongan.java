package com.example.perhitunganpajak2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class Pph21Golongan extends AppCompatActivity {
    private Button bGol, bGol3, bGol4;
    private EditText Nominal;
    private TextView nHasil, nPotongan;
    double a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pph21_golongan);
        bGol = findViewById(R.id.bGol1);
        bGol3 = findViewById(R.id.bGol3);
        bGol4 = findViewById(R.id.bGol4);
        Nominal = findViewById(R.id.nHonor);
        nHasil = findViewById(R.id.nHasil);
        nPotongan = findViewById(R.id.nPotangan);

        bGol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(Nominal.getText().toString());
                b = a * 0 / 100;
                c = a-b;
                DecimalFormat df = new DecimalFormat("#,###,###");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });

        bGol3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(Nominal.getText().toString());
                b = a * 5 / 100;
                c = a-b;
                DecimalFormat df = new DecimalFormat("#,###,###");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });

        bGol4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Integer.parseInt(Nominal.getText().toString());
                b = a * 15 / 100;
                c = a-b;
                DecimalFormat df = new DecimalFormat("#,###,###");
                nPotongan.setText(""+df.format(b));
                nHasil.setText(""+df.format(c));
            }
        });
    }
}