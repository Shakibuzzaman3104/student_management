package com.techtrixbd.studentattendence.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class LockableBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {


        public LockableBottomSheetBehavior() {
            super();
        }


        @Override
        public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
            return false;
        }

        @Override
        public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
            return false;
        }

        @Override
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V child, View directTargetChild, View target, int nestedScrollAxes) {
            return false;
        }

        @Override
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed) {}

        @Override
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target) {}

        @Override
        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
            return false;
        }
}