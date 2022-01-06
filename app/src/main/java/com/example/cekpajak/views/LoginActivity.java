package com.example.cekpajak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cekpajak.R;
import com.example.cekpajak.helpers.UserHelper;
import com.example.cekpajak.models.User;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    UserHelper userHelper ;
    Button btnLogin;
    Button btnRegister;
    EditText emailTxt;
    EditText passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userHelper = new UserHelper(this);
        btnLogin = findViewById(R.id.login);
        btnRegister = findViewById(R.id.register);
        emailTxt =  findViewById(R.id.email);
        passwordTxt = findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String Email = emailTxt.getText().toString();
                    String Password = passwordTxt.getText().toString();

                    User currentUser = userHelper.Authenticate(new User(null, null,null, Email, Password));

                    if (currentUser != null) {
                        Snackbar.make(btnLogin, "Login sukses!", Snackbar.LENGTH_LONG).show();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
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

        String Email = emailTxt.getText().toString();
        String Password = passwordTxt.getText().toString();

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Snackbar.make(mainLayout, "Email harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            valid = true;
        }

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