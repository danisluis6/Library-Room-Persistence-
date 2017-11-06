package com.captech.myapp.localstorage.room.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.captech.myapp.localstorage.room.Entity.Video;
import com.captech.myapp.localstorage.room.utilities.MYContaract;

import java.util.List;

/**
 * Created by lorence on 06/11/2017.
 */

public interface CarDao {

    @Query("SELECT * FROM "+ MYContaract.Column.TABLE)
    List<Video> getCars();

    @Insert
    long insertCars(Video... cars);

    @Update
    int updateCars(Video... cars);

    @Delete
    int deleteCars(Video... cars);

}
