package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.SocketHandler;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Views
        EditText email, password;
        Button loginbutton, signupbutton;

        //Binding
        email = findViewById(R.id.editTextEmailLogin);
        password = findViewById(R.id.editTextPasswordLogin);
        signupbutton = findViewById(R.id.buttonSignUpFromLogin);
        loginbutton = findViewById(R.id.buttonLogin);

        //SharedPrefrences
        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String  passwordText = password.getText().toString();

                String emailStored = sharedPreferences.getString("email", "");
                String passwordStored = sharedPreferences.getString("password", "");

                if(emailText.isEmpty() || passwordText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please fill all the fields!", Toast.LENGTH_LONG).show();
                }else if(emailText.equals(emailStored) && passwordText.equals(passwordStored)){
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();
                    Intent i = new Intent(Login.this, Home.class);
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Account doesn't exist!", Toast.LENGTH_LONG).show();
                }
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
            }
        });
    }
}