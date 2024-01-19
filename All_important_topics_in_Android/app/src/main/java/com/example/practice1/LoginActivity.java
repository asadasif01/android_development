package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private String usernameFromSignup;
    private String passwordFromSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);

        // Retrieve data passed from SignupActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            usernameFromSignup = extras.getString("username");
            passwordFromSignup = extras.getString("password");
        }

        Button loginButton = findViewById(R.id.loginButton);
        Button gotoSignupButton = findViewById(R.id.gotoSignupButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the entered username and password
                String enteredUsername = editTextUsername.getText().toString();
                String enteredPassword = editTextPassword.getText().toString();

                // Check if both fields are filled
                if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the entered username and password match the data from SignupActivity
                    if (enteredUsername.equals(usernameFromSignup) && enteredPassword.equals(passwordFromSignup)) {
                        // Successful login, go to MainActivity
                        Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", enteredUsername);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    } else {
                        // Incorrect username or password, display a message
                        Toast.makeText(LoginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        gotoSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When "Sign Up" button is clicked, open SignupActivity
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
