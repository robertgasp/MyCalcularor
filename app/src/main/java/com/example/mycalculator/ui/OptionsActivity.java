package com.example.mycalculator.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycalculator.R;

public class OptionsActivity extends AppCompatActivity {

    private ThemeStorage themeStorage;
    private Intent intentBack;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        themeStorage = new ThemeStorage(this);

        setTheme(themeStorage.getCurrentTheme().getRes());
        setContentView(R.layout.options);

        View.OnClickListener themeClicker = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.radioButton_for_default_theme) {
                    themeStorage.setCurrentTheme(Theme.Default_theme);

                } else if (v.getId() == R.id.radioButton_for_green_theme) {
                    themeStorage.setCurrentTheme(Theme.My_Green_theme);

                } else if (v.getId() == R.id.radioButton_for_dark_theme) {
                    themeStorage.setCurrentTheme(Theme.My_Dark_theme);
                }
                recreate();
            }
        };

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentBack = new Intent(context, CalcActivity.class);
                startActivity(intentBack);
            }
        });


        findViewById(R.id.radioButton_for_default_theme).setOnClickListener(themeClicker);
        findViewById(R.id.radioButton_for_green_theme).setOnClickListener(themeClicker);
        findViewById(R.id.radioButton_for_dark_theme).setOnClickListener(themeClicker);


    }


}




