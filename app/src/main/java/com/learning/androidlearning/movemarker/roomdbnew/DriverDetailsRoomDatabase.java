package com.learning.androidlearning.movemarker.roomdbnew;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.learning.androidlearning.movemarker.roomdb.DriverDetails;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DriverDetails.class}, version = 9,exportSchema = true)
@TypeConverters({DateTypeConverter.class})
public abstract class DriverDetailsRoomDatabase extends RoomDatabase {
    public abstract DriverDao driverDao();

    private static volatile DriverDetailsRoomDatabase driverDetailsRoomDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DriverDetailsRoomDatabase getDriverDetailsRoomDatabase(final Context context) {
        if (driverDetailsRoomDatabase == null) {
            synchronized (DriverDetailsRoomDatabase.class) {
                if (driverDetailsRoomDatabase == null) {
                    driverDetailsRoomDatabase = Room.databaseBuilder(context.getApplicationContext(), DriverDetailsRoomDatabase.class, "driver_database").
                            fallbackToDestructiveMigration().allowMainThreadQueries().build();
                }
            }
        }
        return driverDetailsRoomDatabase;
    }
}