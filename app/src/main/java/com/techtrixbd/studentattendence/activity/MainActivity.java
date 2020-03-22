package com.techtrixbd.studentattendence.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.techtrixbd.studentattendence.R;
import com.techtrixbd.studentattendence.adapter.IDAdapter;
import com.techtrixbd.studentattendence.databinding.ActivityMainBinding;
import com.techtrixbd.studentattendence.model.ModelAttendence;
import com.techtrixbd.studentattendence.util.CustomListViewDialog;
import com.techtrixbd.studentattendence.util.GridSpacingItemDecoration;
import com.techtrixbd.studentattendence.util.MyBounceInterpolator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;
    boolean isBottomOpen = false;
    List<ModelAttendence> attendenceList;
    IDAdapter adapter;
    CustomListViewDialog customDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        attendenceList = new ArrayList<>();
        adapter = new IDAdapter(getApplicationContext(), attendenceList);

        binding.present.setOnClickListener(v -> {
            final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
            // Use bounce interpolator with amplitude 0.2 and frequency 20
            MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
            myAnim.setInterpolator(interpolator);

            binding.present.startAnimation(myAnim);

            getIds();

            ModelAttendence modelAttendence = new ModelAttendence(sharedPreference.getID(), getCurrentDate(), getCurrentTime());
            apiInterface.attendence(modelAttendence)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.getSuccess())
                            Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(this, "" + response.getMessage(), Toast.LENGTH_SHORT).show();
                    }, t -> {
                        Log.d("MyError", "" + t.getMessage());
                    });
        });

         customDialog = new CustomListViewDialog(MainActivity.this, adapter);



        binding.exit.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        getIds();


        binding.showID.setOnClickListener(v->showDialog());


    }

    public void getIds() {
            apiInterface.get_ids(getCurrentDate())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(attendences->{
                        attendenceList.clear();
                        attendenceList.addAll(attendences);
                        adapter.notifyDataSetChanged();
                    },t->{});
    }

    private void showDialog() {

        customDialog.show();
        customDialog.setCanceledOnTouchOutside(false);

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