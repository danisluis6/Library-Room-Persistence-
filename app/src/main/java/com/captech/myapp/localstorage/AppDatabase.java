package com.captech.myapp.localstorage.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.captech.myapp.localstorage.room.Entity.Topic;
import com.captech.myapp.localstorage.room.Entity.Video;
import com.captech.myapp.localstorage.room.dao.UserDao;

/**
 * @author acampbell
 */
@Database(entities = {Video.class, Topic.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao brandCarDao();
}



