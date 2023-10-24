package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText feet, inches, weight;
        Button calBMI;
        TextView result;
        LinearLayout LLMain;

        feet = findViewById(R.id.feet);
        inches = findViewById(R.id.inches);
        weight = findViewById(R.id.weight);
        calBMI = findViewById(R.id.calBMI);
        result = findViewById(R.id.result);
        LLMain = findViewById(R.id.LLMain);

        calBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int ft = Integer.parseInt(feet.getText().toString());
                int ih = Integer.parseInt(inches.getText().toString());
                int wt = Integer.parseInt(weight.getText().toString());

                // Convert height to meters (height in centimeters divided by 100)
                double meters = (ft * 12 + ih) * 0.0254;

                // Calculate BMI
                double bmi = wt / (meters * meters);

                if (bmi > 25) {
                    result.setText(getResources().getText(R.string.owText));
                    LLMain.setBackgroundColor(Color.parseColor("#FFF44336"));
                } else if (bmi < 18) {
                    result.setText(getResources().getText(R.string.uwText));
                    LLMain.setBackgroundColor(Color.parseColor("#FFFFEB3B"));
                } else {
                    result.setText(getResources().getText(R.string.hText));
                    LLMain.setBackgroundColor(Color.parseColor("#FF4CAF50"));
                }

            }
        });
    }
}
