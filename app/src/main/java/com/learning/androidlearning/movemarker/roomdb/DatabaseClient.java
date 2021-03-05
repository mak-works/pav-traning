package com.learning.androidlearning.movemarker.roomdb;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;
    private DriverDataBase driverDataBase;

    private DatabaseClient(Context mCtx)
    {
        this.mCtx = mCtx;
        driverDataBase = Room.databaseBuilder(mCtx, DriverDataBase.class, "MyToDos").build();

    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }
    public DriverDataBase getDriverDataBase()
    {
        return driverDataBase;
    }

}
