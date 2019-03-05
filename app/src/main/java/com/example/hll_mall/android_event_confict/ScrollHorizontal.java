package com.example.hll_mall.android_event_confict;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class ScrollHorizontal extends LinearLayout {

    private int point_x = 0;
    private int point_y = 0;
    private boolean isOver = true;
    private boolean result;

    public ScrollHorizontal(Context context) {
        super(context);
    }

    public ScrollHorizontal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollHorizontal(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MainActivity.Log("ScrollHorizontal-onInterceptTouchEvent-ACTION_DOWN");
                point_x = (int) ev.getX();
                point_y = (int) ev.getY();
                isOver = false;
                return false;
            case MotionEvent.ACTION_MOVE:
                result = (Math.abs((int) ev.getX() - point_x) > Math.abs((int) ev.getY() - point_y) * 2);
                MainActivity.Log("ScrollHorizontal-onInterceptTouchEvent-ACTION_MOVE   " + String.valueOf(result));
                return result;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MainActivity.Log("ScrollHorizontal-onTouchEvent-ACTION_DOWN   ");
                break;
            case MotionEvent.ACTION_MOVE:
                MainActivity.Log("ScrollHorizontal-onTouchEvent-ACTION_MOVE   ");
                scrollBy((int) (point_x - event.getX()) / 2, 0);
                break;
        }
        return true;
    }

}
