package com.techtrixbd.studentattendence.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.techtrixbd.studentattendence.R;
import com.techtrixbd.studentattendence.model.ModelAttendence;

import java.util.List;

public class IDAdapter extends RecyclerView.Adapter<IDAdapter.ViewHolder> {

    Context context;
    List<ModelAttendence> attendences;

    public IDAdapter(Context context, List<ModelAttendence> attendences) {
        this.context = context;
        this.attendences = attendences;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ids,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.id.setText(attendences.get(position).getStId());

    }

    @Override
    public int getItemCount() {
        return attendences.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
        }
    }
}
