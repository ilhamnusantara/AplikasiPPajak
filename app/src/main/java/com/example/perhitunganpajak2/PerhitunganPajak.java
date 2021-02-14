package com.example.perhitunganpajak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PerhitunganPajak extends AppCompatActivity {
    private EditText nom, eKoma;
    private TextView kalimat, nhasil, show;
    private Button btDPP, btPPN, btPPh21,btPPh22,btPPh23, btPPhFinal ,btPResto;
    double angka,dpp,ppn,pph21,pph22,pph23,presto,panci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan_pajak);

        nom = findViewById(R.id.nHarga);
        show = findViewById(R.id.show);
        btDPP = findViewById(R.id.bDpp);
        btPPN = findViewById(R.id.bPPN);
        btPPh21 = findViewById(R.id.bPPh21);
        btPPh22 = findViewById(R.id.bPPh22);
        btPPh23 = findViewById(R.id.bPPh23);
        btPPhFinal = findViewById(R.id.bFinal);
        btPResto = findViewById(R.id.bPResto);
        kalimat = findViewById(R.id.Hasil);
        nhasil = findViewById(R.id.nHasil);

        nom.addTextChangedListener(new TextWatcher() {
            private String nomrup = nom.getText().toString().trim();
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                show.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==0){
                    show.setVisibility(View.GONE);
                }else{
                    if(!s.toString().equals(nomrup)){
                    nom.removeTextChangedListener(this);
                    String replace = s.toString().replaceAll("[Rp. ]","");
                    if (!replace.isEmpty()){
                        nomrup = formatrupiah(Double.parseDouble(replace));
                    }else{
                        nomrup = "";
                    }
                    show.setText(nomrup);
//                    show.setSelection(nomrup.length());
                    nom.addTextChangedListener(this);
                }

                }
            }
        });
        btDPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else{
                    angka = Integer.parseInt(nom.getText().toString());
                    dpp = angka * 100 / 110;
                    DecimalFormat df = new DecimalFormat("#,###,###.##");
                    kalimat.setText("Nilai Dasar Pengenaan Pajak yang harus dibayar :");
                    nhasil.setText(""+df.format(dpp));
                }
            }
        });

        btPPN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else{
                    angka = Integer.parseInt(nom.getText().toString());
                    dpp = angka * 100 / 110;
                    ppn = dpp * 10 / 100;
                    DecimalFormat df = new DecimalFormat("#,###,###.##");
                    kalimat.setText("Nilai Pajak Pertambahan Nilai yang harus dibayar :");
                    nhasil.setText(""+df.format(ppn));

                }
            }
        });

        btPPh21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else{
                    PPph21();
                }
            }
        });

        btPPh22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else{
                    angka = Integer.parseInt(nom.getText().toString());
                    dpp = angka * 100 / 110;
                    ppn = dpp * 10 / 100;
                    pph22 = ppn * 15 / 100;
                    DecimalFormat df = new DecimalFormat("#,###,###.##");
                    kalimat.setText("Nilai Pajak Penghasilan Pasal 22 yang harus dibayar :");
                    nhasil.setText(""+df.format(pph22));
                }
            }
        });

        btPPh23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else {
                    angka = Integer.parseInt(nom.getText().toString());
                    pph23 = angka * 2 / 100;
                    DecimalFormat df = new DecimalFormat("#,###,###.##");
                    kalimat.setText("Nilai Pajak Penghasilan Pasal 23 yang harus dibayar :");
                    nhasil.setText(""+df.format(pph23));
                }
            }
        });

        btPPhFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else{
                    PPhFinal();
                }
            }
        });

        btPResto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(nom.getText().toString())){
                    Toast.makeText(PerhitunganPajak.this, "Nominal tidak boleh kosong ya zheyeng...", Toast.LENGTH_SHORT).show();
                }
                else{
                    angka = Integer.parseInt(nom.getText().toString());
                    dpp = angka * 100 / 110;
                    presto = dpp * 10 / 100;
                    DecimalFormat df = new DecimalFormat("#,###,###.##");
                    kalimat.setText("Nilai Pajak Pertambahan Nilai yang harus dibayar :");
                    nhasil.setText(""+df.format(presto));
                }
            }
        });
    }

    private String formatrupiah(Double number){
        Locale localeID = new Locale("IND", "ID");
        NumberFormat numberformat = NumberFormat.getCurrencyInstance(localeID);
        String formatrupiah = numberformat.format(number);
        String[] split = formatrupiah.split(",");
        int length = split[0].length();
        return split[0].substring(0,2)+". "+split[0].substring(2, length);
    }
    public void PPph21(){
        String nominal = nom.getText().toString();
        Intent i =new Intent(this, Pph21Golongan.class);
        i.putExtra("nominal", nominal);
        startActivity(i);
    }
    public void  PPhFinal(){
        String nominal = nom.getText().toString();
        Intent i =new Intent(this, PphFinal.class);
        i.putExtra("nominal", nominal);
        startActivity(i);
    }
}