package com.hlx.view.evanhlxcustomview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Administrator on 2018/1/26/026.
 */

public class CustomBroadcastScrollView extends ViewGroup {

    private float mFirstX = 0;//第一次触碰屏幕的x坐标
    private float mLastX = 0;//滑动屏幕时的x坐标
    private float mDispatchX = 0;//在dispatchTouchEvent中滑动屏幕时的x坐标

    private int leftBorder;//界面可滚动的左边界
    private int rightBorder;//界面可滚动的右边界

    private Scroller mScroller;//用于完成滚动的实例

    public CustomBroadcastScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        System.out.println("ev2------->" + ev.getAction());
        getParent().getParent().requestDisallowInterceptTouchEvent(true);
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mFirstX = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                mDispatchX = ev.getX();
                int delX = (int) (mFirstX - mDispatchX);
                if(getScrollX() + delX < leftBorder){//此时为滑动的第一张图片
                    getParent().getParent().requestDisallowInterceptTouchEvent(false);
                }else if(getScrollX() + getWidth() + delX > rightBorder){//此时已经滑动到最后一张图片
                    getParent().getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("event2------->" + event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                mLastX = event.getX();
                int delX = (int) (mFirstX - mLastX);
                if(getScrollX() + delX < leftBorder){
                    scrollTo(leftBorder,0);
                    return true;
                }else if(getScrollX() + getWidth() + delX > rightBorder){
                    scrollTo(rightBorder - getWidth(),0);
                    return true;
                }
                scrollBy(delX,0);
                mFirstX = mLastX;
                break;
            case MotionEvent.ACTION_UP:
                int index = (getScrollX() + getWidth() / 2) / getWidth();
                int dx = index * getWidth() - getScrollX();
                mScroller.startScroll(getScrollX(),0,dx,0);
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        if (b) {
            int childCount = getChildCount();
            for (int j = 0; j < childCount; j++) {
                View view = getChildAt(j);
                view.layout(j * view.getMeasuredWidth(), 0, (j + 1) * view.getMeasuredWidth
                        (), view.getMeasuredHeight());
            }
            leftBorder = getChildAt(0).getLeft();
            rightBorder = getChildAt(childCount - 1).getRight();
        }
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
}
