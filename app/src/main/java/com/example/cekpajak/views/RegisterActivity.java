package com.example.cekpajak.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cekpajak.R;
import com.example.cekpajak.helpers.UserHelper;
import com.example.cekpajak.models.User;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    UserHelper userHelper ;
    View mainLayout;
    Button btnRegister;
    EditText emailTxt;
    EditText usernameTxt;
    EditText companyTxt;
    EditText passwordTxt;
    EditText secondPasswordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userHelper = new UserHelper(this);
        mainLayout = findViewById(R.id.mainLayout);
        btnRegister = findViewById(R.id.register);
        emailTxt =  findViewById(R.id.email);
        usernameTxt = findViewById(R.id.username);
        companyTxt = findViewById(R.id.company_name);
        passwordTxt = findViewById(R.id.password);
        secondPasswordTxt = findViewById(R.id.second_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String Email = emailTxt.getText().toString();
                    String Username = usernameTxt.getText().toString();
                    String CompanyName = companyTxt.getText().toString();
                    String Password = passwordTxt.getText().toString();
                    Boolean isExist = userHelper.isEmailExists(Email);

                    if (isExist){
                        Snackbar.make(mainLayout, "Email telah terdaftar!", Snackbar.LENGTH_LONG).show();
                    }else{
                        userHelper.addUser(new User(null, Username,CompanyName, Email, Password));
                        Snackbar.make(mainLayout, "Berhasil mendaftar!", Snackbar.LENGTH_LONG).show();
                        finish();
                    }
                }
            }
        });
    }

    public boolean validate(){
        boolean valid = false;

        View mainLayout = findViewById(R.id.mainLayout);
        String Email = emailTxt.getText().toString();
        String Username = usernameTxt.getText().toString();
        String CompanyName = companyTxt.getText().toString();
        String Password = passwordTxt.getText().toString();
        String SecondPassword = secondPasswordTxt.getText().toString();

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            Snackbar.make(mainLayout, "Email harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            valid = true;
        }

        //Username
        if (Username.isEmpty()) {
            valid = false;
            Snackbar.make(mainLayout, "Nama pengguna harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            valid = true;
        }

        if (CompanyName.isEmpty()) {
            valid = false;
            Snackbar.make(mainLayout, "Nama instansi harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            valid = true;
        }

        if (Password.isEmpty()) {
            valid = false;
            Snackbar.make(mainLayout, "Password harus diisi!", Snackbar.LENGTH_LONG).show();
        } else {
            if (Password.length() < 6) {
                valid = false;
                Snackbar.make(mainLayout, "Password terlalu pendek!", Snackbar.LENGTH_LONG).show();
            }else if (!Password.equals(SecondPassword)){
                valid = false;
                Snackbar.make(mainLayout, "Konfirmasi password tidak sesuai !", Snackbar.LENGTH_LONG).show();
            }else {
                valid = true;
            }
        }
        return valid;
    }

}