package com.example.helloworld.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ABean implements Parcelable {
    protected ABean(Parcel in) {
    }

    public static final Creator<ABean> CREATOR = new Creator<ABean>() {
        @Override
        public ABean createFromParcel(Parcel in) {
            return new ABean(in);
        }

        @Override
        public ABean[] newArray(int size) {
            return new ABean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
