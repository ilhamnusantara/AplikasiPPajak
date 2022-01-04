package com.example.cekpajak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cekpajak.R;
import com.example.cekpajak.helpers.Db;
import com.example.cekpajak.models.User;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    Db db ;
    Button btnLogin;
    Button btnRegister;
    EditText emailTxt;
    EditText passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Db(this);
        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.register);
        emailTxt =  findViewById(R.id.email);
        passwordTxt = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {

                    //Get values from EditText fields
                    String Email = emailTxt.getText().toString();
                    String Password = passwordTxt.getText().toString();

                    //Authenticate user
                    User currentUser = db.Authenticate(new User(null, null,null, Email, Password));

                    //Check Authentication is successful or not
                    if (currentUser != null) {
                        Snackbar.make(btnLogin, "Login sukses!", Snackbar.LENGTH_LONG).show();

                        //User Logged in Successfully Launch You home screen activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {

                        //User Logged in Failed
                        Snackbar.make(btnLogin, "Gagal login , silahkan coba lagi!", Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean validate(){
        boolean valid = false;
        View mainLayout = findViewById(R.id.mainLayout);
        //Get values from EditText fields
        String Email = emailTxt.getText().toString();
        String Password = passwordTxt.getText().toString();

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Snackbar.make(mainLayout, "Email harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            valid = true;
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            Snackbar.make(mainLayout, "Password harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            if (Password.length() > 5) {
                valid = true;
            } else {
                valid = false;
                Snackbar.make(mainLayout, "Password terlalu pendek!", Snackbar.LENGTH_LONG).show();
            }
        }

        return valid;
    }
}