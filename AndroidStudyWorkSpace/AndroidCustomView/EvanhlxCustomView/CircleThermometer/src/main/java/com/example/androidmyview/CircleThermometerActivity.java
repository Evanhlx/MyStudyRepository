package com.example.androidmyview;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.androidmyview.MyCircleView.GetDegreeInterface;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = "/CircleThermometer/CircleThermometerActivity")
public class CircleThermometerActivity extends Activity implements GetDegreeInterface, OnClickListener {
    private MyCircleView myCircleView;
    private TextView actualDegree;
    private Button clearBt, allBt, okBt;
    private EditText minDegreEditText, maxDegreEditText, cureentDegreEditText;
    String max = "";
    String min = "";
    String current = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_thermometer);
        initView();

        myCircleView.setMinDegree(10);
        myCircleView.setMaxDegree(10);
        myCircleView.setCurrentDegree(10);
        myCircleView.setGetDegreeInterface(this);
    }

    private void initView() {
        myCircleView = (MyCircleView) findViewById(R.id.myCircleView);
        actualDegree = (TextView) findViewById(R.id.actul_degree);
        clearBt = (Button) findViewById(R.id.clear);
        allBt = (Button) findViewById(R.id.all);
        minDegreEditText = (EditText) findViewById(R.id.minDegreeEdit);
        maxDegreEditText = (EditText) findViewById(R.id.maxDegreeEdit);
        cureentDegreEditText = (EditText) findViewById(R.id.currentDegreeEdit);
        okBt = (Button) findViewById(R.id.ok);
        clearBt.setOnClickListener(this);
        allBt.setOnClickListener(this);
        okBt.setOnClickListener(this);

    }

    @Override
    public void getActualDegree(int degree) {
        // TODO 自动生成的方法存根
        actualDegree.setText("当前温度：" + degree + " ℃");
    }

    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.clear) {
            myCircleView.setMinDegree(10);
            myCircleView.setCurrentDegree(10);
            myCircleView.setMaxDegree(10);
            myCircleView.postInvalidate();
        } else if (v.getId() == R.id.all) {
            myCircleView.setMinDegree(10);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    synchronized (CircleThermometerActivity.class) {
                        for (int i = 10; i < 101; i++) {//因为270/3=90
                            try {
                                Thread.sleep(30);
                            } catch (InterruptedException e) {
                                // TODO 自动生成的 catch 块
                                e.printStackTrace();
                            }
                            myCircleView.setMaxDegree(i);
//							j++;
//							if (j<83) {//假如当前温度是34度   （34-10）*3  =72
//								myCircleView.setCurrentDegree(j);
//							}
                            myCircleView.postInvalidate();
                        }
                    }
                }
            }).start();
        } else if (v.getId() == R.id.ok) {

            if (checkDegreeInput()) {
                showDegree(Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(current));
            }
        }


    }

    /**
     * @param minDegree     最低温度
     * @param maxDegree     最高温度
     * @param currentDegree 当前温度
     */
    private void showDegree(final int minDegree, final int maxDegree, final int currentDegree) {
        myCircleView.setMinDegree(minDegree);
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = minDegree; i < (maxDegree - minDegree) * 3 + minDegree; i++) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        // TODO 自动生成的 catch 块
                        e.printStackTrace();
                    }

                    myCircleView.setMaxDegree(i);
                    myCircleView.postInvalidate();
                }
                for (int j = 10; j <= (currentDegree - 10) * 3 + 10; j++) {
                    if (j <= (currentDegree - 10) * 3 + 10) {//23*3+10=79
                        myCircleView.setCurrentDegree(j);
                    }
                    myCircleView.postInvalidate();
                }
            }
        }).start();

//    	new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int j = 10; j<=(currentDegree-10)*3+10; j++) {
//					if (j<=(currentDegree-10)*3+10) {//23*3+10=79
//						myCircleView.setCurrentDegree(j);
//					}
//					myCircleView.postInvalidate();
//				}
//			}
//		}).start();
    }

    /**
     * 检查编辑框输入
     *
     * @return
     */
    private boolean checkDegreeInput() {
        boolean flag = false;
        max = maxDegreEditText.getText().toString();
        min = minDegreEditText.getText().toString();
        current = cureentDegreEditText.getText().toString();
        if (TextUtils.isEmpty(max) || TextUtils.isEmpty(min)
                || TextUtils.isEmpty(current)) {
            Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Integer.parseInt(max) > Integer.parseInt(min)
                && Integer.parseInt(max) >= Integer.parseInt(current)
                && Integer.parseInt(current) >= Integer.parseInt(min)
                && Integer.parseInt(min) >= 10 && Integer.parseInt(max) <= 40) {
            flag = true;
        } else {
            Toast.makeText(this, "输入有误", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        return flag;

    }

}
