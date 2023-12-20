package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecylcerViewScreen extends AppCompatActivity {

    FloatingActionButton btnOpen;
    RecyclerContactAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<ContactModel> arrContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylcer_view_screen);

        recyclerView = findViewById(R.id.recScreen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Open Button Click
        btnOpen = findViewById(R.id.fab);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(RecylcerViewScreen.this, "You click the button", Toast.LENGTH_SHORT).show();

                Dialog dialog = new Dialog(RecylcerViewScreen.this);
                dialog.setContentView(R.layout.add_update_layout);
                dialog.show();

                EditText ename = dialog.findViewById(R.id.addname);
                EditText erollno = dialog.findViewById(R.id.addrollno);
                Button btnAction = dialog.findViewById(R.id.addrecord);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = ename.getText().toString();
                        String rollno = erollno.getText().toString();

                        if (name.isEmpty()) {
                            Toast.makeText(RecylcerViewScreen.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                        } else if (rollno.isEmpty()) {
                            Toast.makeText(RecylcerViewScreen.this, "Please Enter Rollno", Toast.LENGTH_SHORT).show();
                        } else {
                            arrContacts.add(new ContactModel(R.drawable.image6,name, rollno));

//                            adapter = new RecyclerContactAdapter(getApplicationContext(), arrContacts);
//                            recyclerView.setAdapter(adapter);

                            adapter.notifyItemInserted(arrContacts.size() - 1);
                            recyclerView.scrollToPosition(arrContacts.size() - 1);
                            dialog.dismiss();
                        }
                    }
                });

            }
        });

        arrContacts.add(new ContactModel(R.drawable.image6, "Muhammad Asad", "bitf20m533"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Husnain Malhi", "bitf20m539"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Hammad Tahir", "bitf20m540"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Usama Basharat", "bitf20m528"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Ahmad Malik", "bitf20m534"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Ahmad Ali", "bitf20m544"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Taimoor Ali", "bitf20m530"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Laraib Sheikh", "bitf20m551"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Zeeshan Nazir", "bitf20m547"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Maqbool Bhai", "bitf20m524"));

        adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}
