package com.example.mycalculator.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.example.mycalculator.R;
import com.example.mycalculator.main.CalcMainLogic;

import java.text.DecimalFormat;

public class CalcActivityExecution implements Parcelable, CalcViewInterface{

    private final String savedScreen;

    CalcActivity calcActivity;
    protected CalcActivityExecution expression, digits;


    private final static String EXPRESSION_KEY = "EXPRESSION_KEY";
    private final static String DIGITS_KEY = "DIGITS_KEY";

    Bundle outState;

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


    public void showResult(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.############");
        String resultF = decimalFormat.format(result);
        calcActivity.showDigits(resultF);
    }

    public void clearEveryThing() {
        expression = new CalcActivityExecution("");
        outState.putParcelable(EXPRESSION_KEY, expression);
        digits = new CalcActivityExecution("");
        outState.putParcelable(DIGITS_KEY, digits);
        calcActivity.showExpression(outState.getParcelable(EXPRESSION_KEY));
        calcActivity.showDigits(outState.getParcelable(DIGITS_KEY));
    }


    public void clearDigits() {
        calcActivity.showDigits("");
    }



    public void appendDigits(String number) {

        digits = new CalcActivityExecution(outState.getParcelable(DIGITS_KEY) + number);
        outState.putParcelable(DIGITS_KEY, expression);
        calcActivity.showDigits(outState.getParcelable(DIGITS_KEY));

    }


    public void appendExpression(String exp) {
        expression = new CalcActivityExecution(outState.getParcelable(EXPRESSION_KEY) + exp);
        outState.putParcelable(EXPRESSION_KEY, expression);
        calcActivity.showExpression(outState.getParcelable(EXPRESSION_KEY));
    }

    @Override
    public void showExpression(String string) {

    }

    @Override
    public void showDigits(String string) {

    }
}
