package com.example.practice1.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(Users users);

    @Query("DELETE from Users where id=:id")
    void delete(int id);

    @Query("DELETE from Users")
    void deleteAll();

    @Query("Select * from Users")
    List<Users> getAllUsers();
}
