package com.captech.roomdemo.localstorage.room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.captech.roomdemo.localstorage.room.utils.EEConstract;

/**
 *
 * Created by lorence on 06/11/2017.
 */

@Entity(tableName = EEConstract.EEUser.TABLE)
public class User implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = EEConstract.EEUser.ID)
    private int id;

    @ColumnInfo(name = EEConstract.EEUser.USERNAME)
    private String username;

    @ColumnInfo(name = EEConstract.EEUser.PASSWORD)
    private String password;

    protected User(Parcel in) {
        id = in.readInt();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(username);
        dest.writeString(password);
    }
}
