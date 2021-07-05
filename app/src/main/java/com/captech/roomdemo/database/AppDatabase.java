package com.captech.roomdemo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.captech.roomdemo.dao.ContactDao;
import com.captech.roomdemo.domain.Contact;

/**
 * @author acampbell
 */
@Database(entities = {Contact.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "app_db";

    public abstract ContactDao getContactDao();
}



