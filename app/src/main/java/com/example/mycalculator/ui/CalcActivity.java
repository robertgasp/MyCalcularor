package com.example.mycalculator.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycalculator.R;
import com.example.mycalculator.main.CalcExpressionInterface;
import com.example.mycalculator.main.CalcMainLogic;
import com.example.mycalculator.main.Operations;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.content.Context;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener, CalcViewInterface  {

    private TextView expression, digits;

    CalcPresenter presenter = new CalcPresenter(this, new CalcMainLogic());
    private CalcActivityExecution savedExpression;
    private CalcActivityExecution savedDigits;
    private final static String EXPRESSION_KEY = "EXPRESSION_KEY";
    private final static String DIGITS_KEY = "DIGITS_KEY";
    Intent intent;
    private ThemeStorage themeStorage;

    private final int[] numberButton = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3,
            R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        themeStorage = new ThemeStorage(this);
        setTheme(themeStorage.getCurrentTheme().getRes());

        setContentView(R.layout.activity_main);


        expression = findViewById(R.id.expression);
        digits = findViewById(R.id.digits);


        findViewById(R.id.btn_options).setOnClickListener(v -> {
            intent = new Intent(this, OptionsActivity.class);

            startActivity(intent);

        });


        findViewById(R.id.btn_AC).setOnClickListener(v -> presenter.clickButtonAC());

        findViewById(R.id.btn_CD).setOnClickListener(v -> presenter.clickButtonCD());

        findViewById(R.id.btn_plus).setOnClickListener(v -> presenter.clickButtonPlus());

        findViewById(R.id.btn_minus).setOnClickListener(v -> presenter.clickButtonMinus());

        findViewById(R.id.btn_multiply).setOnClickListener(v -> presenter.clickButtonMul());

        findViewById(R.id.btn_division).setOnClickListener(v -> presenter.clickButtonDiv());

        findViewById(R.id.btn_equal).setOnClickListener(v -> presenter.clickButtonEqual());

        findViewById(R.id.btn_dot).setOnClickListener(v -> presenter.clickButtonDot());
        determButtonNumberListener();

        findViewById(R.id.btn_percent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonPercent();
            }
        });
    }


    public void determButtonNumberListener() {
        for (int i = 0; i < numberButton.length; i++) {
            int index = i;
            findViewById(numberButton[i]).setOnClickListener(v -> {
                presenter.clickButtonNumber(index);
            });
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        savedExpression = new CalcActivityExecution(String.valueOf(expression.getText()));
        savedDigits = new CalcActivityExecution(String.valueOf(digits.getText()));
        outState.putParcelable(EXPRESSION_KEY, savedExpression);
        outState.putParcelable(DIGITS_KEY, savedDigits);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle outState) {

        super.onRestoreInstanceState(outState);
        savedExpression = outState.getParcelable(EXPRESSION_KEY);
        savedDigits = outState.getParcelable(DIGITS_KEY);

        expression.setText(savedExpression.getSavedScreen());
        digits.setText(savedDigits.getSavedScreen());
    }

    @Override
    public void onClick(View v) {
    }

@Override
    public void showExpression(String string) {
        expression.setText(string);
    }

    @Override
    public void showDigits(String string) {
        digits.setText(string);
    }


}