package com.learning.androidlearning.movemarker.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.learning.androidlearning.movemarker.roomdbnew.DateTypeConverter;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DriverDetails implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int driverId;

    @ColumnInfo(name = "mobileNumber")
    private String mobileNumber;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date")
    @TypeConverters({DateTypeConverter.class})
    private Date date;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
