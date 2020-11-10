package com.example.samplebottomsheetdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author zhanglulu on 2020/11/2.
 * for 适配 BottomSheetDialog 的 ListView ，解决手势冲突
 */
public class BottomSheetRecyclerView extends RecyclerView {
    private static final String TAG = "BottomSheetRecyclerView";

    public BottomSheetRecyclerView(@NonNull Context context) {
        super(context);
    }

    public BottomSheetRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomSheetRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float lastY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: canScrollVertically(-1): " + canScrollVertically(-1));
        float curY = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = curY;
                break;
            case MotionEvent.ACTION_MOVE:

                if (curY - lastY < 0) {
                    Log.d(TAG, "允许滑动");
                    return super.dispatchTouchEvent(ev);
                }
                if (!canScrollVertically(-1)) {
                    Log.d(TAG, "禁止滑动");
                    return true;
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
