package com.learning.androidlearning.movemarker.roomdbnew;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.learning.androidlearning.movemarker.roomdb.DriverDetails;

import java.util.List;

public class DriverDetailRepository {

    private DriverDao driverDao;
    private List<DriverDetails> driverDetails;

    public DriverDetailRepository(Application application) {
        DriverDetailsRoomDatabase driverDetailsRoomDatabase = DriverDetailsRoomDatabase.getDriverDetailsRoomDatabase(application);
        driverDao = driverDetailsRoomDatabase.driverDao();
        driverDetails = driverDao.getDriverDetails();

    }
    public List<DriverDetails> getAllDriverDetails(){
            return driverDetails;
        }
        public void insert(DriverDetails driverDetails)
        {
            DriverDetailsRoomDatabase.databaseWriteExecutor.execute(()->{
                driverDao.insert(driverDetails);
            });
        }
        public void delete() {
        DriverDetailsRoomDatabase.databaseWriteExecutor.execute(() -> {
            driverDao.deleteLastSevenDaysData();
        });
    }
}
