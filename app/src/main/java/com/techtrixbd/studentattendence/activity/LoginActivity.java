package com.techtrixbd.studentattendence.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.techtrixbd.studentattendence.databinding.ActivityLoginBinding;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.techtrixbd.studentattendence.util.Util.isValidID;


public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.register.setOnClickListener(v->{
            startActivity(new Intent(this,RegistrationActivity.class));
            finish();
        });

        binding.login.setOnClickListener(v->{
            if (!isValidID(binding.etId.getText().toString().trim()))
                binding.etId.setError("Invalid id");
            else
            {
                apiInterface.login(binding.etId.getText().toString().trim())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(modelResponse -> {

                            if(modelResponse.getSuccess())
                            {
                                startActivity(new Intent(this,MainActivity.class));
                                sharedPreference.setID(binding.etId.getText().toString().trim());
                                sharedPreference.setIsFirstBoot(false);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(this, ""+modelResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        },throwable -> {

                        });
            }
        });
    }



}
