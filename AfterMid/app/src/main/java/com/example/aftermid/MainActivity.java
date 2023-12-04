package com.example.aftermid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aftermid.Room.UserDao;
import com.example.aftermid.Room.UserDatabase;
import com.example.aftermid.Room.Users;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListner {

    EditText nameEd, emailEd;
    Button btn;
    RecyclerView myrecyler;
    Button deleteAllButton;
    private UserDatabase userDatabase;
    private UserDao userDao;
    private UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userDatabase = UserDatabase.getInstance(this);
        userDao = userDatabase.getDao();

        nameEd = findViewById(R.id.name);
        emailEd = findViewById(R.id.email);
        btn = findViewById(R.id.insert);
        myrecyler = findViewById(R.id.userRec);
        deleteAllButton = findViewById(R.id.deleteAll);

        userAdapter = new UserAdapter(this, this);
        myrecyler.setAdapter(userAdapter);
        myrecyler.setLayoutManager(new LinearLayoutManager(this));

        fetchData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEd.getText().toString();
                String email = emailEd.getText().toString();
                if (!name.isEmpty() && !email.isEmpty()) {
                    Users user = new Users(0, name, email);

                    userDao.insert(user);
                    userAdapter.addUser(user);

                    // After Inserting
                    nameEd.setText("");
                    emailEd.setText("");
                    emailEd.clearFocus();
                    Toast.makeText(MainActivity.this, "Data Inserted 😊", Toast.LENGTH_LONG).show();
                } else {
                    // Handle the case where userDao or nameEd is null
                    Toast.makeText(MainActivity.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDao.deleteAll();
               userAdapter.removeAllUser();
            }
        });
    }

    private void fetchData(){
        List<Users> usersList = userDao.getAllUsers();
        for(int i=0; i<usersList.size(); i++){
            Users user = usersList.get(i);
            userAdapter.addUser(user);
        }
    }

    @Override
    public void onDelete(int id, int pos) {
        userDao.delete(id);
        userAdapter.removeUser(pos);
    }
}
