package com.example.mycalculator.main;

public interface CalcExpressionInterface {
    double oper(double value1, double value2, Operations operation);

    double operPercent(double value1, double value2, OperationPercent operationPercent);
}
