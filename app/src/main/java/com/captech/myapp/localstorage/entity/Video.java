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
 * @Run: https://developer.android.com/topic/libraries/architecture/room.html
 * Created by lorence on 06/11/2017.
 *//*


@Entity(tableName = DatabaseInfo.Tables.Video)
public class Video implements Parcelable {

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
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseInfo.Video.COLUMN_ID)
    private int id;
    @ColumnInfo(name = DatabaseInfo.Video.COLUMN_URL)
    private String url;
    @ColumnInfo(name = DatabaseInfo.Video.COLUMN_TOPIC_ID)
    private int topic_id;

    protected Video(Parcel in) {
        id = in.readInt();
        url = in.readString();
        topic_id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
        dest.writeInt(topic_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}
*/
