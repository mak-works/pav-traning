package com.learning.androidlearning.movemarker.roomdb;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.sql.Driver;
import java.util.List;

@Dao
public interface DriverDetailsDao
{
    @Query("SELECT * FROM DriverDetails")
    List<DriverDetails> getDriverDetails();

    @Insert
    void insert(DriverDetails driverDetails);

    @Update
    void update(DriverDetails driverDetails);

    @Delete
    void delete(DriverDetails driverDetails);

}