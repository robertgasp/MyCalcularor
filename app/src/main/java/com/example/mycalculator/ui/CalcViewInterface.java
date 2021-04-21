package com.example.mycalculator.ui;

import android.view.View;

import com.example.mycalculator.main.Operations;

public interface CalcViewInterface {


    void showResult(double result);

    void clearEveryThing(String blank);

    void clearDigits(String blank);

    String getDigits();

    void appendDigits(String dig);

    void appendExpression(String exp);


}
