package com.techtrixbd.studentattendence.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.techtrixbd.studentattendence.retrofit.ApiClient;
import com.techtrixbd.studentattendence.retrofit.ApiInterface;
import com.techtrixbd.studentattendence.util.MySharedPreference;

public class BaseActivity extends AppCompatActivity {

    MySharedPreference sharedPreference;
    ApiInterface apiInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreference = MySharedPreference.getPreferencesInstance(getApplicationContext());
        apiInterface = ApiClient.getInstance();


    }
}
