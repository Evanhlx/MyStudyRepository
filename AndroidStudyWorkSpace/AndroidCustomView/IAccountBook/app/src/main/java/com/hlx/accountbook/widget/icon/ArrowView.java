package com.hlx.accountbook.widget.icon;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ArrowView extends android.support.v7.widget.AppCompatImageView {
    private ArrowDrawable mDrawable;

    public ArrowView(Context context) {
        super(context);
    }

    public ArrowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ArrowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mDrawable = new ArrowDrawable();
        setImageDrawable(mDrawable);
    }


}
