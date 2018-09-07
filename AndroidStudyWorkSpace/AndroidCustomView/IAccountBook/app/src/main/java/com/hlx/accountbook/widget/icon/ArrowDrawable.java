package com.hlx.accountbook.widget.icon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class ArrowDrawable extends Drawable implements Animatable {
    private String TAG = getClass().getName();
    private int left;
    private int top;
    private int right;
    private int bottom;


    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        Log.d(TAG, "setBounds: left " + left + " top " + top + " right " + right + " bottom " + bottom);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        //1-准备-笔
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#390038"));
        paint.setStrokeWidth(5);
        int gene = Math.min(right, bottom);

        canvas.drawLine(0.5F * gene, 0.33F * gene, 0.3F * gene, 0.5F * gene, paint);
        canvas.drawLine(0.3F * gene, 0.5F * gene, 0.5F * gene, 0.67F * gene, paint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
