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

@Entity(tableName = EEConstract.EECar.TABLE)
public class Car implements Parcelable {

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = EEConstract.EECar.ID)
    private int id;
    @ColumnInfo(name = EEConstract.EECar.NAME)
    private String name;
    @ColumnInfo(name = EEConstract.EECar.BRAND)
    private String brand;
    @ColumnInfo(name = EEConstract.EECar.ENGINE)
    private String engine;
    @ColumnInfo(name = EEConstract.EECar.MODE)
    private String mode;

    protected Car(Parcel in) {
        id = in.readInt();
        name = in.readString();
        brand = in.readString();
        engine = in.readString();
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(brand);
        dest.writeString(engine);
        dest.writeString(mode);
    }
}
