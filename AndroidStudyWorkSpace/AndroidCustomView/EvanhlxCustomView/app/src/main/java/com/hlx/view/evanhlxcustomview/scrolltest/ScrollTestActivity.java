package com.hlx.view.evanhlxcustomview.scrolltest;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hlx.view.evanhlxcustomview.R;
import com.hlx.view.evanhlxcustomview.view.CustomLinearLayout;
import com.hlx.view.evanhlxcustomview.view.CustomView;

/**
 * 测试View的坐标系
 *
 * 结论：
 *
 * View中自身方法：
 view.getTop();               //获取子View左上角距父View顶部的距离
 view.getLeft();              //获取子View左上角距父View左侧的距离
 view.getBottom();            //获取子View右下角距父View顶部的距离
 view.getRight();             //获取子View右下角距父View左侧的距离

 view.getTranslationX()：计算的是该View在X轴的偏移量。初始值为0，向左偏移值为负，向右偏移值为正。
 view.getTranslationY()：计算的是该View在Y轴的偏移量。初始值为0，向上偏移为负，向下偏移为正。
 view.getX=view.getTranslationX()+view.getLeft() 相当于该view距离父容器左边缘的距离
 view.getY=view.getTranslationY()+view.getTop()

 前面四个值 和getX 、getY 随
 1、父控件的padding变化，前面四个值 和getX 、getY 变化。而不受父控件的margin值的影响。
 2、自身的margin值变化，前面四个值 和getX 、getY 变化。而不受自身padding值的影响。
 *
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ScrollTestActivity extends AppCompatActivity {

    private CustomView mCustomView;
    CustomLinearLayout mCustomLi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scroll_test);
        mCustomLi = (CustomLinearLayout) findViewById(R.id.c_ll);
        mCustomView = (CustomView) findViewById(R.id.c_view);

        testMutipleListener();

       /* mCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ScrollTestActivity", "--mCustomView setOnClickListener-- -ACTION_DOWN-");
            }
        });*/

        Log.i("ScrollTestActivity", "left : " + mCustomView.getLeft());


        mCustomView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("ScrollTestActivity", "--mCustomView setOnTouchListener-- -ACTION_DOWN-");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.i("ScrollTestActivity", "--mCustomView setOnTouchListener-- -ACTION_MOVE-");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("ScrollTestActivity", "--mCustomView setOnTouchListener-- -ACTION_UP-");
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.i("ScrollTestActivity", "--mCustomView setOnTouchListener-- -ACTION_CANCEL-");
                        break;
                }
                return false;
            }
        });

    }


    private void testMutipleListener() {
        Button btn = (Button) findViewById(R.id.button5);
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),"--OnLong---ClickListener--",Toast.LENGTH_SHORT).show();
                Log.w("testMutipleListener","--OnLong---ClickListener--");
                return true;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"--OnClickListener--",Toast.LENGTH_SHORT).show();
                Log.w("testMutipleListener","--OnClickListener--");
            }
        });

//        btn.setOnContextClickListener(new View.OnContextClickListener() {
//            @Override
//            public boolean onContextClick(View v) {
//                Toast.makeText(getApplicationContext(),"--OnContextClickListener--",Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(getApplicationContext(),"--OnTouchListener--",Toast.LENGTH_SHORT).show();
                Log.w("testMutipleListener","--OnTouchListener--");
                return true;
            }
        });
    }

    public void addMarginLeft(View view) {
        Log.i("ScrollTestActivity", "addMarginLeft before --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = mCustomView.getLeft() + 100;
        mCustomView.setLayoutParams(params);
        mCustomView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ScrollTestActivity", "addMarginLeft after --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
            }
        }, 500);
    }

    public void addParentMarginLeft(View view) {
        Log.i("ScrollTestActivity", "addParentMarginLeft before --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = mCustomLi.getLeft() + 100;
        mCustomLi.setLayoutParams(params);
        mCustomView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ScrollTestActivity", "addParentMarginLeft after --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
            }
        }, 500);
    }

    public void ObjAnimation(View view) {
        ObjectAnimator.ofFloat(mCustomView, "translationX", 0, 100).setDuration(2000).start();
        Log.i("ScrollTestActivity", " ObjAnimation before --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
        mCustomView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ScrollTestActivity", " ObjAnimation after --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
            }
        }, 3000);
    }

    public void addPaddingLeft(View view) {
        Log.i("ScrollTestActivity", "addPaddingLeft before --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
        int paddingLeft = mCustomView.getPaddingLeft() + 100;
        mCustomView.setPadding(paddingLeft, 0, 0, 0);
        mCustomView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ScrollTestActivity", "addPaddingLeft after --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
            }
        }, 500);
    }

    public void addParentPaddingLeft(View view) {
        Log.i("ScrollTestActivity", "addParentPaddingLeft before --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
        int paddingLeft = mCustomLi.getPaddingLeft() + 100;
        mCustomLi.setPadding(paddingLeft, 0, 0, 0);
        mCustomView.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("ScrollTestActivity", "addParentPaddingLeft after --> left : " + mCustomView.getLeft() + " getX : " + mCustomView.getX() + " getTranslationX: " + mCustomView.getTranslationX());
            }
        }, 500);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
    }

    /*@Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.i("ScrollTestActivity","--dispatchTouchEvent--");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("ScrollTestActivity", "--dispatchTouchEvent-- -ACTION_DOWN-");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("ScrollTestActivity", "--dispatchTouchEvent-- -ACTION_MOVE-");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("ScrollTestActivity", "--dispatchTouchEvent-- -ACTION_UP-");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("ScrollTestActivity", "--dispatchTouchEvent-- -ACTION_CANCEL-");
                break;
        }
//        boolean superEventB = getWindow().superDispatchTouchEvent(event);
        boolean superEventB = true;
        Log.e("ScrollTestActivity", "--getWindow().superDispatchTouchEvent(event)  ：  " + superEventB);

        try {
//            boolean superCOTB = getWindow().shouldCloseOnTouch(this, event);
//            Log.e("ScrollTestActivity", "--getWindow().shouldCloseOnTouch(this, event)  ：  " + superCOTB);
        }catch(Exception e){
            Log.e("ScrollTestActivity","close ON Touch "+e.getMessage());
        }

        boolean superValue = super.dispatchTouchEvent(event);
        Log.e("ScrollTestActivity", "--super.dispatchTouchEvent(event)  ：  " + superValue);

        return superValue;
    }*/

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        Log.w("ScrollTestActivity", "--onUserInteraction-- -onUserInteraction-");

    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.w("ScrollTestActivity", "--onUserLeaveHint-- -onUserLeaveHint-");
    }
}


