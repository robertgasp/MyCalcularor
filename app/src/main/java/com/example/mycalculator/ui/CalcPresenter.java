package com.example.mycalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mycalculator.main.CalcExpressionInterface;
import com.example.mycalculator.main.OperationPercent;
import com.example.mycalculator.main.Operations;

public class CalcPresenter {
    private CalcExpressionInterface calculator;
    private CalcViewInterface activity;

    private CalcActivityExecution calcActivityExecution;

    private final static String EXPRESSION_KEY = "EXPRESSION_KEY";
    private final static String DIGITS_KEY = "DIGITS_KEY";

    double value1 = 0, value2 = 0;
    static double value1ForPercent;
    char operationForPercent;
    CalcActivity calcActivity;


    Bundle outState;

    double result;
    char op;
    Intent intent;

    public CalcPresenter(CalcViewInterface activity, CalcExpressionInterface calculator) {
        this.calculator = calculator;
        this.activity = activity;
    }


    void clickButtonAC() {
        calcActivityExecution.clearEveryThing();
    }

    public void clickButtonCD() {
        calcActivityExecution.clearDigits();
    }

    public void clickButtonPlus() {
        value1 = Double.parseDouble(outState.getParcelable(DIGITS_KEY));
        value1ForPercent = value1;


        calcActivityExecution.appendExpression(" + ");
        calcActivityExecution.clearDigits();
        op = '+';

    }

    public void clickButtonMinus() {
        if (String.valueOf(outState.getParcelable(DIGITS_KEY)).isEmpty()) {
            calcActivityExecution.appendDigits("-");
        } else {
            value1 = Double.parseDouble(outState.getParcelable(DIGITS_KEY));
            value1ForPercent = value1;
            calcActivityExecution.appendExpression(" - ");
            calcActivityExecution.clearDigits();
            op = '-';
        }
    }

    public void clickButtonMul() {
        value1 = Double.parseDouble(outState.getParcelable(DIGITS_KEY));
        value1ForPercent = value1;
        calcActivityExecution.appendExpression(" * ");
        calcActivityExecution.clearDigits();
        op = '*';

    }

    public void clickButtonDiv() {
        value1 = Double.parseDouble(outState.getParcelable(DIGITS_KEY));
        value1ForPercent = value1;
        calcActivityExecution.appendExpression(" / ");
        calcActivityExecution.clearDigits();
        op = '/';
    }

    public void clickButtonPercent() {
        value1 = value1ForPercent;
        value2 = Double.parseDouble(outState.getParcelable(DIGITS_KEY));
        String str = outState.getParcelable(EXPRESSION_KEY);
        operationForPercent = str.charAt(str.length() - 2);
        calcActivityExecution.appendExpression(outState.getParcelable(DIGITS_KEY) + "% =");
        calcActivityExecution.clearDigits();
        if (operationForPercent == '+') {
            result = calculator.operPercent(value1, value2, OperationPercent.PLUS);
            calcActivityExecution.showResult(result);
        } else if (operationForPercent == '-') {
            result = calculator.operPercent(value1, value2, OperationPercent.MINUS);
            calcActivityExecution.showResult(result);
        } else if (operationForPercent == '*') {
            result = calculator.operPercent(value1, value2, OperationPercent.MUL);
            calcActivityExecution.showResult(result);
        } else if (operationForPercent == '/') {
            result = calculator.operPercent(value1, value2, OperationPercent.DIV);
            calcActivityExecution.showResult(result);
        }

    }

    public void clickButtonEqual() {
        value2 = Double.parseDouble(outState.getParcelable(DIGITS_KEY));
        calcActivityExecution.appendExpression(value2 + " = ");
        if (op == '+') {
            result = calculator.oper(value1, value2, Operations.PLUS);

            calcActivityExecution.showResult(result);
        } else if (op == '-') {
            result = calculator.oper(value1, value2, Operations.MINUS);
            calcActivityExecution.showResult(result);
        } else if (op == '*') {
            result = calculator.oper(value1, value2, Operations.MUL);
            calcActivityExecution.showResult(result);
        } else if (op == '/') {
            result = calculator.oper(value1, value2, Operations.DIV);
            calcActivityExecution.showResult(result);
        }
    }

    public void clickButtonNumber(int i) {
        calcActivityExecution.appendDigits(String.valueOf(i));
    }


    public void clickButtonDot() {
        calcActivityExecution.appendDigits(".");
    }


}


