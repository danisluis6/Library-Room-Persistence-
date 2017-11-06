package com.captech.roomdemo.localstorage.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.captech.roomdemo.localstorage.room.Entity.Car;
import com.captech.roomdemo.localstorage.room.Entity.User;
import com.captech.roomdemo.localstorage.room.dao.UserDao;

/**
 * @author acampbell
 */
@Database(entities = {Car.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao brandCarDao();
}



