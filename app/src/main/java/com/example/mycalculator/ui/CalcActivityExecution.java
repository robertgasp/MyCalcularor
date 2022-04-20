package com.example.mycalculator.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcActivityExecution implements Parcelable {

    private final String savedScreen;


    public CalcActivityExecution(String string) {
        savedScreen = string;
    }


    protected CalcActivityExecution(Parcel in) {
        savedScreen = in.readString();
    }

    public static final Creator<CalcActivityExecution> CREATOR = new Creator<CalcActivityExecution>() {
        @Override
        public CalcActivityExecution createFromParcel(Parcel in) {
            return new CalcActivityExecution(in);
        }

        @Override
        public CalcActivityExecution[] newArray(int size) {
            return new CalcActivityExecution[size];
        }
    };


    public String getSavedScreen() {
        return savedScreen;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(savedScreen);

    }

}
