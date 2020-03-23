package com.techtrixbd.studentattendence.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techtrixbd.studentattendence.R;
import com.techtrixbd.studentattendence.activity.MainActivity;

public class CustomListViewDialog extends Dialog implements View.OnClickListener {

    public ProgressBar progressBar;

    public CustomListViewDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomListViewDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    public MainActivity activity;
    public Dialog dialog;
    public Button refresh;
    TextView title;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter adapter;


    public CustomListViewDialog(MainActivity a, RecyclerView.Adapter adapter) {
        super(a);
        this.activity = a;
        this.adapter = adapter;
        setupLayout();
    }

    private void setupLayout() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_show_ids);
        refresh = (Button) findViewById(R.id.refresh);
        title = findViewById(R.id.title);
        progressBar = findViewById(R.id.progress);
        recyclerView = findViewById(R.id.bottom_recycler);
        mLayoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(mLayoutManager);


        activity.getIds();

        recyclerView.setAdapter(adapter);
        refresh.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.refresh:
                progressBar.setVisibility(View.VISIBLE);
                activity.getIds();
                break;
            default:
                break;
        }

    }
}
