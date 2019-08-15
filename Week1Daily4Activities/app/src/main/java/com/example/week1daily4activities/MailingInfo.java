package com.example.week1daily4activities;


import android.os.Parcel;
import android.os.Parcelable;

public class MailingInfo implements Parcelable {
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;

    public MailingInfo(String firstName, String lastName, String streetAddress, String city, String state, String zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public MailingInfo(MailingInfo toCopy){
        this.firstName = toCopy.getFirstName();
        this.lastName = toCopy.getLastName();
        this.streetAddress = toCopy.streetAddress;
        this.city = toCopy.getCity();
        this.state = toCopy.getState();
        this.zip = toCopy.getZip();
    }

    protected MailingInfo(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        streetAddress = in.readString();
        city = in.readString();
        state = in.readString();
        zip = in.readString();
    }

    public static final Creator<MailingInfo> CREATOR = new Creator<MailingInfo>() {
        @Override
        public MailingInfo createFromParcel(Parcel in) {
            return new MailingInfo(in);
        }

        @Override
        public MailingInfo[] newArray(int size) {
            return new MailingInfo[size];
        }
    };

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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(streetAddress);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(zip);
    }
}
