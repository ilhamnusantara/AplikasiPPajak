package com.example.perhitunganpajak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btPP = findViewById(R.id.bPp);
        Button btInf = findViewById(R.id.bInform);
        TextView help = findViewById(R.id.textView5);

        btPP.setOnClickListener(this);
        btInf.setOnClickListener(this);
        help.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bPp:
                Intent hitungPajak = new Intent(MainActivity.this, PerhitunganPajak.class);
                startActivity(hitungPajak);
                break;

            case R.id.bInform:
                Intent lihatInfo = new Intent(MainActivity.this, InformasiPajak.class);
                startActivity(lihatInfo);
                break;

            case R.id.textView5:
                String phoneNumber = new String("03114045");
                Intent callForHelp = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(callForHelp);
        }
    }
}