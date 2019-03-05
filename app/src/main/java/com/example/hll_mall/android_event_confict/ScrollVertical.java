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
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                MainActivity.Log("ScrollVertical-onTouchEvent-ACTION_DOWN");
                point_x = (int) event.getX();
                point_y = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                scrollBy(0, point_y-(int) event.getY() );
                MainActivity.Log("ScrollVertical-onTouchEvent-ACTION_MOVE");
                break;
            default:
                break;
        }
        return true;
    }
}
