package com.hlx.view.evanhlxcustomview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/1/16/016.
 */

public class CustomView extends ImageView {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("CustomView","--dispatchTouchEvent-- -ACTION_DOWN-");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("CustomView","--dispatchTouchEvent-- -ACTION_MOVE-");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("CustomView","--dispatchTouchEvent-- -ACTION_UP-");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("CustomView","--dispatchTouchEvent-- -ACTION_CANCEL-");
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("CustomView","--onTouchEvent-- -ACTION_DOWN-");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("CustomView","--onTouchEvent-- -ACTION_MOVE-");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("CustomView","--onTouchEvent-- -ACTION_UP-");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("CustomView","--onTouchEvent-- -ACTION_CANCEL-");
                break;
        }
        return super.onTouchEvent(event);
    }
}
