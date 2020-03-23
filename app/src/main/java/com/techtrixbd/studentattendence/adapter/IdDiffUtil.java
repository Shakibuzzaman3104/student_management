package com.techtrixbd.studentattendence.adapter;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.techtrixbd.studentattendence.model.ModelAttendence;

import java.util.List;

public class IdDiffUtil extends DiffUtil.Callback {

        private  List<ModelAttendence> oldAttendance;
        private  List<ModelAttendence> newAttendenace;

        public IdDiffUtil(List<ModelAttendence> oldAttendanceList, List<ModelAttendence> newAttendanceList) {
            this.oldAttendance = oldAttendanceList;
            this.newAttendenace = newAttendanceList;
        }

        @Override
        public int getOldListSize() {
            return oldAttendance.size();
        }

        @Override
        public int getNewListSize() {
            return newAttendenace.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldAttendance.get(oldItemPosition).getId().equals(newAttendenace.get(
                    newItemPosition).getId());
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            final ModelAttendence oldAttendance1 = oldAttendance.get(oldItemPosition);
            final ModelAttendence newAttendance2 = newAttendenace.get(newItemPosition);

            return oldAttendance1.getStId().equals(newAttendance2.getStId());
        }

        @Nullable
        @Override
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            // Implement method if you're going to use ItemAnimator
            return super.getChangePayload(oldItemPosition, newItemPosition);
        }
    }

