package com.example.samplebottomsheetdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class InterceptParentTouchLinerLayout extends LinearLayout {
    public InterceptParentTouchLinerLayout(Context context) {
        super(context);
    }

    public InterceptParentTouchLinerLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptParentTouchLinerLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        getParent().getParent().requestDisallowInterceptTouchEvent(true);
        getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

}
