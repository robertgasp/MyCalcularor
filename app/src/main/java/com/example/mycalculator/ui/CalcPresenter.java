package com.example.mycalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.mycalculator.main.CalcExpressionInterface;
import com.example.mycalculator.main.OperationPercent;
import com.example.mycalculator.main.Operations;

public class CalcPresenter {
    private CalcExpressionInterface calculator;
    private CalcViewInterface activity;
    CalcActivity calcActivity;

    private CalcActivityExecution calcActivityExecution;
    private final static String SCREEN_KEY = "EXPRESSION_KEY";

    double value1 = 0, value2 = 0;
    static double value1ForPercent;
    char operationForPercent;
    double digits;

    double result;
    char op;
    Intent intent;

    public CalcPresenter(CalcViewInterface activity, CalcExpressionInterface calculator) {
        this.calculator = calculator;
        this.activity = activity;
    }


    void clickButtonAC() {
        activity.clearEveryThing();
    }

    public void clickButtonCD() {
        activity.clearDigits();
    }

    public void clickButtonPlus() {
        value1 = Double.parseDouble(activity.getDigits());
        value1ForPercent = value1;
        activity.appendExpression(activity.getDigits() + " + ");
        activity.clearDigits();
        op = '+';

    }

    public void clickButtonMinus() {
        if (activity.getDigits().isEmpty()) {
            activity.appendDigits("-");
        } else {
            value1 = Double.parseDouble(activity.getDigits());
            value1ForPercent = value1;
            activity.appendExpression(activity.getDigits() + " - ");
            activity.clearDigits();
            op = '-';
        }
    }

    public void clickButtonMul() {
        value1 = Double.parseDouble(activity.getDigits());
        value1ForPercent = value1;
        activity.appendExpression(activity.getDigits() + " * ");
        activity.clearDigits();
        op = '*';

    }

    public void clickButtonDiv() {
        value1 = Double.parseDouble(activity.getDigits());
        value1ForPercent = value1;
        activity.appendExpression(activity.getDigits() + " / ");
        activity.clearDigits();
        op = '/';
    }

    public void clickButtonPercent() {
        value1 = value1ForPercent;
        value2 = Double.parseDouble(activity.getDigits());
        String str = activity.getExpression();
        operationForPercent = str.charAt(str.length() - 2);
        activity.appendExpression(activity.getDigits() + "% =");
        activity.clearDigits();
        if (operationForPercent == '+') {
            result = calculator.operPercent(value1, value2, OperationPercent.PLUS);
            activity.showResult(result);
        } else if (operationForPercent == '-') {
            result = calculator.operPercent(value1, value2, OperationPercent.MINUS);
            activity.showResult(result);
        } else if (operationForPercent == '*') {
            result = calculator.operPercent(value1, value2, OperationPercent.MUL);
            activity.showResult(result);
        } else if (operationForPercent == '/') {
            result = calculator.operPercent(value1, value2, OperationPercent.DIV);
            activity.showResult(result);
        }

    }

    public void clickButtonEqual() {
        value2 = Double.parseDouble(activity.getDigits());
        activity.appendExpression(value2 + " = ");
        if (op == '+') {
            result = calculator.oper(value1, value2, Operations.PLUS);

            activity.showResult(result);
        } else if (op == '-') {
            result = calculator.oper(value1, value2, Operations.MINUS);
            activity.showResult(result);
        } else if (op == '*') {
            result = calculator.oper(value1, value2, Operations.MUL);
            activity.showResult(result);
        } else if (op == '/') {
            result = calculator.oper(value1, value2, Operations.DIV);
            activity.showResult(result);
        }
    }

    public void clickButtonNumber(int i) {
        activity.appendDigits(String.valueOf(i));
    }


    public void clickButtonDot() {
        activity.appendDigits(".");
    }


    public void clickButtonOptions() {
        intent = new Intent((Context) activity, OptionsActivity.class);
        calcActivity.finish();
    }
}


