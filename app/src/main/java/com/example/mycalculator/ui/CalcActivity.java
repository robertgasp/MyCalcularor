package com.example.mycalculator.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mycalculator.R;
import com.example.mycalculator.main.CalcMainLogic;

import java.text.DecimalFormat;

public class CalcActivity extends AppCompatActivity implements CalcViewInterface, View.OnClickListener {

    private TextView expression, digits;
    private CalcPresenter presenter;
    private CalcActivity activity;
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

        presenter = new CalcPresenter(this, new CalcMainLogic());

        expression = findViewById(R.id.expression);
        digits = findViewById(R.id.digits);
       // calcActivityExecution = new CalcActivityExecution(expression, digits);


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
        savedExpression=new CalcActivityExecution(String.valueOf(expression.getText()));
        savedDigits=new CalcActivityExecution(String.valueOf(digits.getText()));
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
    public void showResult(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.############");
        String resultF = decimalFormat.format(result);
        digits.setText(resultF);
    }

    @Override
    public void clearEveryThing() {
        expression.setText("");
        digits.setText("");
    }

    @Override
    public void clearDigits() {
        digits.setText("");
    }


    @Override
    public String getExpression() {
        String value = String.valueOf(expression.getText());
        return value;
    }

    @Override
    public String getDigits() {
        String value = String.valueOf(digits.getText());
        return value;
    }

    @Override
    public void appendDigits(String number) {
        digits.append(String.valueOf(number));
    }

    @Override
    public void appendExpression(String exp) {
        expression.append(exp);
    }


    @Override
    public void onClick(View v) {
    }

}