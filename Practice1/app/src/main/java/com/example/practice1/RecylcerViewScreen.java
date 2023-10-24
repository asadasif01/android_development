package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecylcerViewScreen extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylcer_view_screen);

        RecyclerView recyclerView = findViewById(R.id.recScreen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new ContactModel(R.drawable.image6, "Muhammad Asad", "bitf20m533"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Husnain Malhi", "bitf20m539"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Hammad Tahir", "bitf20m540"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Usama Basharat", "bitf20m528"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Muhammad Ahmad", "bitf20m534"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Ahmad Ali", "bitf20m544"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Taimoor Ali", "bitf20m530"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Laraib Sheikh", "bitf20m551"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Zeeshan Nazir", "bitf20m547"));
        arrContacts.add(new ContactModel(R.drawable.image6, "Maqbool Bhai", "bitf20m524"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}