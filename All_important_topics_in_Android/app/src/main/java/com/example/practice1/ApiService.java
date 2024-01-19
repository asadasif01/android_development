package com.example.practice1;

import com.example.practice1.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface ApiService {
    @GET("/api/users/{uid}")
    Call<List<UserData>> getUser(@Path("uid") int uid);
}

