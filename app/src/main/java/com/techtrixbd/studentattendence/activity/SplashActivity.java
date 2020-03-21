package com.techtrixbd.studentattendence.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.techtrixbd.studentattendence.util.MySharedPreference;

public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MySharedPreference sharedPreference = MySharedPreference.getPreferencesInstance(getApplicationContext());
        Intent intent;

        if(sharedPreference.isFirstBoot())
        {
            intent = new Intent(this, LoginActivity.class);
        }
        else
        {
            intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
        finish();
    }

}