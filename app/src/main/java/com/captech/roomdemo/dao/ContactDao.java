package com.captech.roomdemo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.captech.roomdemo.domain.Contact;

import java.util.List;

/**
 *
 * Created by lorence on 02/11/2017.
 */

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contact")
    List<Contact> getContacts();

    @Insert
    long insertContacts(Contact contact);

    @Update
    int updateContacts(Contact... contacts);

    @Delete
    int deleteContacts(Contact... contacts);
}
