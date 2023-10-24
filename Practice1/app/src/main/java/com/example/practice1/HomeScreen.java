package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //Getting Name
        Bundle bundle = getIntent().getExtras();
        String name = "Asad";
        if(bundle!= null){
            name = bundle.getString("name", "Asad");
        }

        //Setting Name
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome Back "+ name);
        setSupportActionBar(toolbar);


        //Applying ClickListner for BMI Calaculator
        Button bmibutton = findViewById(R.id.btnCalculateBMI);
        bmibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button recbutton = findViewById(R.id.btnRecyclerView);
        recbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RecylcerViewScreen.class);
                startActivity(i);
            }
        });
    }
}