package com.captech.roomdemo.localstorage.room.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.captech.roomdemo.localstorage.room.Entity.Car;
import com.captech.roomdemo.localstorage.room.utils.EEConstract;

import java.util.List;

/**
 *
 * Created by lorence on 06/11/2017.
 */

public interface UserDao {

    @Query("SELECT * FROM "+ EEConstract.EEUser.TABLE)
    List<Car> getUsers();

    @Insert
    long insertUsers(Car... cars);

    @Update
    int updateUsers(Car... cars);

    @Delete
    int deleteUsers(Car... cars);
}
