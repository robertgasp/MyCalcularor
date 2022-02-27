package com.example.mycalculator.main;

import com.example.mycalculator.ui.CalcPresenter;

public class CalcMainLogic implements CalcExpressionInterface {


    @Override
    public double oper(double value1, double value2, Operations operation) {
        switch (operation) {


            case PLUS: {

                return value1 + value2;
            }
            case MINUS: {

                return value1 - value2;
            }
            case MUL: {

                return value1 * value2;
            }
            case DIV: {

                return value1 / value2;
            }
        }
        return 0;
    }

    @Override
    public double operPercent(double value1, double value2, OperationPercent operationPercent) {
        switch (operationPercent) {
            case PLUS:
                return value1 + ((value1 / 100) * value2);
            case MINUS:
                return value1 - ((value1 / 100) * value2);
            case MUL:
                return value1 * ((value1 / 100) * value2);
            case DIV:
                return value1 / ((value1 / 100) * value2);
        }
        return 0;
    }

}
