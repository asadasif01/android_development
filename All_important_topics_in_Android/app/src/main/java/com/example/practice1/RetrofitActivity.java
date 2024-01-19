package com.example.practice1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RetrofitActivity extends AppCompatActivity {

    private TextView textView, textView2, textView3;

    interface ApiService {
        @GET("/api/users/{uid}")
        Call<UserData> getUser(@Path("uid") String uid);

        // Add other API endpoints as needed
        // Example:
        // @GET("/api/users")
        // Call<List<UserData>> getUsers();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retro_fit);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getUser("2").enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()) {
                    UserData userData = response.body();
                    updateUI(userData);
                } else {
                    Toast.makeText(getApplicationContext(), "Response error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void updateUI(UserData userData) {
        if (userData != null && userData.getData() != null) {
            UserData.DataClass data = userData.getData();
            textView.setText("First Name: " + data.getFirst_name());
            textView2.setText("ID: " + data.getId());
            textView3.setText("Email: " + data.getEmail());
        }
    }
}
