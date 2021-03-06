package com.example.mycalculator.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mycalculator.R;
import com.example.mycalculator.main.CalcExpressionInterface;
import com.example.mycalculator.main.CalcMainLogic;
import com.example.mycalculator.main.Operations;

import java.text.DecimalFormat;

public class CalcActivity extends AppCompatActivity implements CalcViewInterface, View.OnClickListener {

    private TextView expression, digits;
    private CalcPresenter presenter;
    private CalcActivity activity;
    private final static String EXPRESSION_KEY = "EXPRESSION_KEY";
    private final static String DIGITS_KEY = "DIGITS_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        presenter = new CalcPresenter(this, new CalcMainLogic());


        expression = findViewById(R.id.expression);
        digits = findViewById(R.id.digits);


        findViewById(R.id.btn_AC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonAC();
            }
        });

        findViewById(R.id.btn_CD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonCD();
            }
        });

        findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonPlus();
            }
        });

        findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonMinus();
            }
        });

        findViewById(R.id.btn_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonMul();
            }
        });

        findViewById(R.id.btn_division).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonDiv();
            }
        });

        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonEqual();
            }
        });

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton1();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton2();
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton3();
            }
        });

        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton4();
            }
        });

        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton5();
            }
        });

        findViewById(R.id.btn_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton6();
            }
        });

        findViewById(R.id.btn_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton7();
            }
        });

        findViewById(R.id.btn_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton8();
            }
        });

        findViewById(R.id.btn_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton9();
            }
        });

        findViewById(R.id.btn_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButton0();
            }
        });

        findViewById(R.id.btn_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickButtonDot();
            }
        });

//        findViewById(R.id.btn_percent).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                presenter.clickButtonPercent();
//            }
//        });

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(EXPRESSION_KEY, String.valueOf(expression.getText()));
        outState.putString(DIGITS_KEY, String.valueOf(digits.getText()));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        String restoredExpression = savedInstanceState.getString(EXPRESSION_KEY);
        expression.setText(restoredExpression);

        String restoredDigits = savedInstanceState.getString(DIGITS_KEY);
        digits.setText(restoredDigits);
        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public void showResult(double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#.############");
        String resultF = decimalFormat.format(result);
        digits.setText(resultF);


    }

    @Override
    public void clearEveryThing(String clear) {
        expression.setText("");
        digits.setText("");

    }

    @Override
    public void clearDigits(String blank) {
        digits.setText("");
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