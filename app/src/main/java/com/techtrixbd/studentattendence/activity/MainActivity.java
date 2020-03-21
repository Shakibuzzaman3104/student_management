package com.techtrixbd.studentattendence.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.techtrixbd.studentattendence.R;
import com.techtrixbd.studentattendence.databinding.ActivityMainBinding;
import com.techtrixbd.studentattendence.model.ModelAttendence;
import com.techtrixbd.studentattendence.util.MyBounceInterpolator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.present.setOnClickListener(v -> {

            final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

            // Use bounce interpolator with amplitude 0.2 and frequency 20
            MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
            myAnim.setInterpolator(interpolator);

            binding.present.startAnimation(myAnim);

            ModelAttendence modelAttendence = new ModelAttendence(sharedPreference.getID(), getCurrentDate(),getCurrentTime());
            apiInterface.attendence(modelAttendence)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.getSuccess())
                            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this, ""+response.getMessage(), Toast.LENGTH_SHORT).show();
                    }, t -> {
                        Log .d("MyError", "" + t.getMessage());
                    });
        });


        binding.exit.setOnClickListener(v->{
            finish();
            System.exit(0);
        });
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

}