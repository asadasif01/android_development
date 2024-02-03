package com.example.database_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextFatherName, editTextMobile, editTextEmail, editTextPassword;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale, radioButtonFemale;
    Button buttonSubmit;
    CheckBox checkBoxTerms;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextFatherName = findViewById(R.id.editTextFatherName);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);

        dbHelper = new DBHelper(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitDataToDatabase();
            }
        });
    }

    private void submitDataToDatabase() {
        String name = editTextName.getText().toString().trim();
        String fatherName = editTextFatherName.getText().toString().trim();
        String mobileStr = editTextMobile.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (name.isEmpty() || fatherName.isEmpty() || mobileStr.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!checkBoxTerms.isChecked()) {
            Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Parse mobile number as integer
        long mobile = Long.parseLong(mobileStr);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("father_name", fatherName);
        values.put("mobile", mobile); // Store mobile number as integer
        values.put("email", email);
        values.put("password", password);
        int selectedId = radioGroupGender.getCheckedRadioButtonId();
        if (selectedId == radioButtonMale.getId()) {
            values.put("gender", "Male");
        } else if (selectedId == radioButtonFemale.getId()) {
            values.put("gender", "Female");
        }
        long newRowId = db.insert("my_table", null, values);
        if (newRowId != -1) {
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Failed to insert data", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        editTextName.getText().clear();
        editTextFatherName.getText().clear();
        editTextMobile.getText().clear();
        editTextEmail.getText().clear();
        editTextPassword.getText().clear();
        radioButtonMale.setChecked(false);
        radioButtonFemale.setChecked(false);
        checkBoxTerms.setChecked(false);
    }
}