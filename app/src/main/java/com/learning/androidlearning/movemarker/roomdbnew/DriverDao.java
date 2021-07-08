package com.learning.androidlearning.movemarker.roomdbnew;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learning.androidlearning.movemarker.roomdb.DriverDetails;

import java.util.List;

@Dao
public interface DriverDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)//ignores a new one if exactly same as already in list
    void insert(DriverDetails driverDetails);

    @Query("DELETE FROM DriverDetails")
    void deleteall();

    @Query("SELECT * FROM DriverDetails")
    List<DriverDetails> getDriverDetails();

    @Query("DELETE FROM DriverDetails  WHERE date <= date('now','-4 day')")
    void deleteLastSevenDaysData();
}
