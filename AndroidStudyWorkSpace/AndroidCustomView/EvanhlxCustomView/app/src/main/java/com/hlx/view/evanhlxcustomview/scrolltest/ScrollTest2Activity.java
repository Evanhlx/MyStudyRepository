package com.hlx.view.evanhlxcustomview.scrolltest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hlx.view.evanhlxcustomview.R;

public class ScrollTest2Activity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    Button scrollBtn;
    private TextView scrollTv;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test2);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        scrollBtn = (Button) findViewById(R.id.scroll_btn);
        scrollTv = (TextView) findViewById(R.id.scroll_tv);

        scrollBtn.setOnTouchListener(this);
        scrollTv.setOnTouchListener(this);

        mTextView = (TextView) this.findViewById(R.id.tv);

        mButton1 = (Button) this.findViewById(R.id.button_scroll1);
        mButton2 = (Button) this.findViewById(R.id.button_scroll2);
        mButton3 = (Button) this.findViewById(R.id.button_scroll3);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.button_scroll1:
                mTextView.scrollTo(-10, -10);
                break;
            case R.id.button_scroll2:
                mTextView.scrollBy(-2, -2);
                break;
            case R.id.button_scroll3:
                mTextView.scrollTo(0, 0);
                break;
            default:
                break;
        }
    }

    float oldX;
    float oldY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                oldX = event.getRawX();
                oldY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = (int) (event.getRawX() - oldX);
                int offsetY = (int) (event.getRawY() - oldY);
                mTextView.scrollBy(-offsetX,-offsetY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (v.getId()) {
            case R.id.scroll_btn:
                scrollBtn.scrollBy(x, y);
                break;
            case R.id.scroll_tv:
                scrollTv.scrollBy(x, y);
                break;
        }
        return false;
    }
}
