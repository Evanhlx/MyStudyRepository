package com.hlx.view.evanhlxcustomview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/1/11/011.
 */

public class CusScrollView extends ViewGroup {
    private int lastX = 0;
    private int lastRawX = 0;
    private int currX = 0;
    private int currRawX = 0;
    private int offX = 0;
    private int offRawX = 0;

    private Scroller mScroller;

    /**
     * @param context
     */
    public CusScrollView(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     */
    public CusScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CusScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        mScroller = new Scroller(context);
    }

    /*
    * (non-Javadoc)
    *
    * @see android.view.ViewGroup#onLayout(boolean, int, int, int, int)
    */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // TODO Auto-generated method stub

        for (int i = 0; i < getChildCount(); i++) {
            View v = getChildAt(i);
            v.layout(0 + i * getWidth(), 0, getWidth() + i * getWidth(),
                    getHeight());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 只考虑水平方向
                lastX = (int) event.getX();
                lastRawX = (int) event.getRawX();
                return true;

            case MotionEvent.ACTION_MOVE:
                currX = (int) event.getX();
                currRawX = (int) event.getRawX();
                offX = currX - lastX;
                offRawX = currRawX - lastRawX;
//                scrollBy(-offX, 0);
                mScroller.startScroll(getScrollX(),0,-offRawX,0);
                break;

            case MotionEvent.ACTION_UP:
//                scrollTo(0, 0);
                mScroller.startScroll(getScrollX(),0,0,0);
//                mScroller.startScroll(getScrollX(),0,-100,0);
                break;
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),0);
//            invalidate();
//            getParent().requestDisallowInterceptTouchEvent(true);
            postInvalidate();
        }
        super.computeScroll();
    }
}
