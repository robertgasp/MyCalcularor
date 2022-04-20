package com.example.mycalculator.ui;

import com.example.mycalculator.R;

public enum Theme {


    Default_theme("default_theme", R.style.Theme_MyCalculator),
    My_Green_theme("my_green_theme", R.style.Theme_MyGreenTheme),
    My_Dark_theme("my_dark_theme", R.style.Theme_MyDarkTheme);

    private final String key;
    private final int res;

    Theme(String key, int res) {
        this.key = key;
        this.res = res;
    }

    public String getKey() {
        return key;
    }

    public int getRes() {
        return res;
    }
}
