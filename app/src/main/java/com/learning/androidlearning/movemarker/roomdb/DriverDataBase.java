package com.learning.androidlearning.movemarker.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {DriverDetails.class}, version = 1)
    public abstract class DriverDataBase extends RoomDatabase
    {
        public abstract DriverDetailsDao DriverDetailsDao();
    }

