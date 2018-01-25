package com.hlx.view.evanhlxcustomview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2018/1/16/016.
 */

public class CustomLinearLayout extends LinearLayout {
    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

//        Log.i("CoustomLinearLayou","--dispatchTouchEvent--");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("CoustomLinearLayou","--dispatchTouchEvent-- -ACTION_DOWN-");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("CoustomLinearLayou","--dispatchTouchEvent-- -ACTION_MOVE-");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("CoustomLinearLayou","--dispatchTouchEvent-- -ACTION_UP-");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("CoustomLinearLayou","--dispatchTouchEvent-- -ACTION_CANCEL-");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("CoustomLinearLayou","--onTouchEvent-- -ACTION_DOWN-");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("CoustomLinearLayou","--onTouchEvent-- -ACTION_MOVE-");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("CoustomLinearLayou","--onTouchEvent-- -ACTION_UP-");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("CoustomLinearLayou","--onTouchEvent-- -ACTION_CANCEL-");
                break;
        }
        return super.onTouchEvent(event);
    }
}
