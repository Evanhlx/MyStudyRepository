package com.hlx.accountbook.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/22/022.
 */

public class Message implements Comparable<Message>,Parcelable {
    public String number;
    public String date;
    public String body;
    public String person;
    public Long longDate;

    public Message(String body, long date, String number, String person) {
        this.body = body;
        this.number = number;
        this.person = person;
        parseDate(date);
    }

    private void parseDate(long date) {
//        if(date == null || date.trim() == "")
//            date = "-1";
        try {
            longDate = new Long(date);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.date = formatter.format(new Date(longDate));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(@NonNull Message o) {
        if(this.longDate > o.longDate){
            return 1;
        }else if(this.longDate < o.longDate){
            return -1;
        }
        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.number);
        dest.writeString(this.date);
        dest.writeString(this.body);
        dest.writeString(this.person);
        dest.writeValue(this.longDate);
    }

    protected Message(Parcel in) {
        this.number = in.readString();
        this.date = in.readString();
        this.body = in.readString();
        this.person = in.readString();
        this.longDate = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
