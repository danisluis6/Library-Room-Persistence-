/*
package com.captech.myapp.localstorage.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.captech.myapp.localstorage.DatabaseInfo;


*/
/**
 *
 * Created by lorence on 06/11/2017.
 *//*


@Entity(tableName = DatabaseInfo.Tables.Topic)
public class Topic implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.Topic.COLUMN_ID)
    private int id;

    @ColumnInfo(name = DatabaseInfo.Topic.COLUMN_NAME)
    private String name;

    private Topic(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        @Override
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }

        @Override
        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
*/
