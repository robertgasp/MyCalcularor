package com.example.mycalculator.main;

public class CalcMainLogic implements CalcExpressionInterface {


    @Override
    public double oper(double value1, double value2, Operations operation) {
        switch (operation) {
            case PLUS:
                return value1 + value2;
            case MINUS:
                return value1 - value2;
            case MUL:
                return value1 * value2;
            case DIV:
                return value1 / value2;
            case PERCENT:
                return (value1 / 100) * value2;
        }
        return 0;
    }
}
