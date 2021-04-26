package com.example.mycalculator.ui;

import com.example.mycalculator.R;
import com.example.mycalculator.main.CalcExpressionInterface;
import com.example.mycalculator.main.CalcMainLogic;
import com.example.mycalculator.main.Operations;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

public class CalcPresenter {
    private CalcExpressionInterface calculator;
    private CalcViewInterface activity;

    double value1 = 0, value2 = 0;
    double digits;
    double result;
    char op;

    public CalcPresenter(CalcViewInterface activity, CalcExpressionInterface calculator) {
        this.calculator = calculator;
        this.activity = activity;
    }


    void clickButtonAC() {
        activity.clearEveryThing("");
    }

    public void clickButtonCD() {
        activity.clearDigits("");
    }

    public void clickButtonPlus() {
        value1 = Double.parseDouble(activity.getDigits());
        activity.appendExpression(activity.getDigits() + " + ");
        activity.clearDigits("");
        op = '+';

    }

    public void clickButtonMinus() {
        value1 = Double.parseDouble(activity.getDigits());
        activity.appendExpression(activity.getDigits() + " - ");
        activity.clearDigits("");
        op = '-';
    }

    public void clickButtonMul() {
        value1 = Double.parseDouble(activity.getDigits());
        activity.appendExpression(activity.getDigits() + " * ");
        activity.clearDigits("");
        op = '*';

    }

    public void clickButtonDiv() {
        value1 = Double.parseDouble(activity.getDigits());
        activity.appendExpression(activity.getDigits() + " / ");
        activity.clearDigits("");
        op = '/';
    }

//    public void clickButtonPercent() {
//        value1 = Double.parseDouble(activity.getDigits());
//
//        activity.clearDigits("");
//        op = '%';
//    }

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
        } else if (op == '%') {
            activity.appendExpression(activity.getDigits() + "% =  ");
            result = calculator.oper(value1, value2, Operations.PERCENT);
            activity.showResult(result);
        }
    }

    public void clickButtonNumber(int i){
        activity.appendDigits(String.valueOf(i));
    }


    public void clickButtonDot() {
        activity.appendDigits(".");
    }

}


