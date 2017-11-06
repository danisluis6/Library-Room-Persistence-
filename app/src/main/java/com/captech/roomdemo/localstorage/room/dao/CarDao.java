package com.captech.roomdemo.localstorage.room.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.captech.roomdemo.localstorage.room.Entity.Car;
import com.captech.roomdemo.localstorage.room.utils.EEConstract;

import java.util.List;

/**
 * Created by lorence on 06/11/2017.
 */

public interface CarDao {

    @Query("SELECT * FROM "+ EEConstract.EECar.TABLE)
    List<Car> getCars();

    @Insert
    long insertCars(Car... cars);

    @Update
    int updateCars(Car... cars);

    @Delete
    int deleteCars(Car... cars);

}
