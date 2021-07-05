package com.captech.roomdemo.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import com.captech.roomdemo.utils.Constant;

/**
 *
 * Created by lorence on 02/11/2017.
 */

@Entity(tableName = "contact")
public class Contact implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contact_id")
    private int contactID;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "number")
    private String number;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] avatar;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "address")
    private String address;

    @Ignore
    public Contact() {
        firstName = lastName = number = email = address = Constant.EMPTY_STRING;
    }

    public Contact(String firstName, String lastName, String number, byte[] avatar, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.avatar = avatar;
        this.email = email;
        this.address = address;
    }

    protected Contact(Parcel in) {
        contactID = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        number = in.readString();
        email = in.readString();
        address = in.readString();
    }

    public static final Creator<com.captech.roomdemo.domain.Contact> CREATOR = new Creator<com.captech.roomdemo.domain.Contact>() {
        @Override
        public com.captech.roomdemo.domain.Contact createFromParcel(Parcel in) {
            return new com.captech.roomdemo.domain.Contact(in);
        }

        @Override
        public com.captech.roomdemo.domain.Contact[] newArray(int size) {
            return new com.captech.roomdemo.domain.Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(contactID);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(number);
        dest.writeString(email);
        dest.writeString(address);
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
