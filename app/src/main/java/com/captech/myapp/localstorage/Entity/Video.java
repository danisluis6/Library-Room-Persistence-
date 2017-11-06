package com.captech.myapp.localstorage.room.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.captech.myapp.localstorage.room.utilities.MYContaract;

/**
 * @Run: https://developer.android.com/topic/libraries/architecture/room.html
 * Created by lorence on 06/11/2017.
 */

@Entity(tableName = MYContaract.Video.TABLE)
public class Video implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = MYContaract.Video.COLUMN_ID)
    private int id;

    @ColumnInfo(name = MYContaract.Video.COLUMN_URL)
    private String url;

    protected Video(Parcel in) {
        id = in.readInt();
        url = in.readString();
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
    }
}
