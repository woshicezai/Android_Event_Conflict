package com.example.hll_mall.android_event_confict;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class ScrollVertical extends LinearLayout {
    private int point_x = 0;
    private int point_y = 0;
    private boolean isIntercept;

    public ScrollVertical(Context context) {
        super(context);
    }

    public ScrollVertical(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollVertical(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                point_x = (int) ev.getX();
                point_y = (int) ev.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
                MainActivity.Log("ScrollVertical-dispatchTouchEvent-ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                isIntercept = (Math.abs(ev.getX() - point_x) < Math.abs(ev.getY() - point_y) * 2);
                MainActivity.Log("ScrollVertical-dispatchTouchEvent-ACTION_MOVE " + String.valueOf(isIntercept));
                getParent().requestDisallowInterceptTouchEvent(isIntercept);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MainActivity.Log("ScrollVertical-onInterceptTouchEvent-ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                MainActivity.Log("ScrollVertical-onInterceptTouchEvent-ACTION_MOVE");
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MainActivity.Log("ScrollVertical-onTouchEvent-ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                scrollBy(0, (point_y - (int) event.getY()) / 4);
                MainActivity.Log("ScrollVertical-onTouchEvent-ACTION_MOVE");
                break;
            default:
                break;
        }
        return true;
    }
}
