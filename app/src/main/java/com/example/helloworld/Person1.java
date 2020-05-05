package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;

public class Person1  implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
