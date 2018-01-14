package com.example.androidmyview;

import com.example.androidmyview.MyCircleView.GetDegreeInterface;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements GetDegreeInterface, OnClickListener {
	private MyCircleView myCircleView;
	private TextView actualDegree;
	private Button clearBt,allBt,okBt;
	private EditText minDegreEditText,maxDegreEditText,cureentDegreEditText;
	String max = "";
	String min = "";
	String current = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

		myCircleView.setMinDegree(10);
		myCircleView.setMaxDegree(10);
		myCircleView.setCurrentDegree(10);
		myCircleView.setGetDegreeInterface(this);
	}

	private void initView() {
		myCircleView=(MyCircleView) findViewById(R.id.myCircleView);
		actualDegree=(TextView) findViewById(R.id.actul_degree);
		clearBt=(Button) findViewById(R.id.clear);
		allBt=(Button) findViewById(R.id.all);
		minDegreEditText=(EditText) findViewById(R.id.minDegreeEdit);
		maxDegreEditText=(EditText) findViewById(R.id.maxDegreeEdit);
		cureentDegreEditText=(EditText) findViewById(R.id.currentDegreeEdit);
		okBt=(Button) findViewById(R.id.ok);
		clearBt.setOnClickListener(this);
		allBt.setOnClickListener(this);
		okBt.setOnClickListener(this);

	}
	@Override
	public void getActualDegree(int degree) {
		// TODO 自动生成的方法存根
		actualDegree.setText("当前温度："+degree+" ℃");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.clear:
				myCircleView.setMinDegree(10);
				myCircleView.setCurrentDegree(10);
				myCircleView.setMaxDegree(10);
				myCircleView.postInvalidate();
				break;
			case R.id.all:
				myCircleView.setMinDegree(10);
				new Thread(new Runnable() {

					@Override
					public void run() {
						synchronized (MainActivity.class) {
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
				break;
			case R.id.ok:
				if(checkDegreeInput()){
					showDegree(Integer.parseInt(min),Integer.parseInt(max),Integer.parseInt(current));
				}
				break;

			default:
				break;
		}

	}

	/**
	 *
	 * @param minDegree  最低温度
	 * @param maxDegree  最高温度
	 * @param currentDegree 当前温度
	 */
	private void showDegree(final int minDegree, final int maxDegree, final int currentDegree) {
		myCircleView.setMinDegree(minDegree);
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = minDegree; i < (maxDegree-minDegree)*3+minDegree; i++) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					myCircleView.setMaxDegree(i);
					myCircleView.postInvalidate();
				}
				for (int j = 10; j<=(currentDegree-10)*3+10; j++) {
					if (j<=(currentDegree-10)*3+10) {//23*3+10=79
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
	 * @return
	 */
	private boolean checkDegreeInput() {
		boolean flag = false;
		max = maxDegreEditText.getText().toString();
		min = minDegreEditText.getText().toString();
		current = cureentDegreEditText.getText().toString();
		if (TextUtils.isEmpty(max) || TextUtils.isEmpty(min)
				|| TextUtils.isEmpty(current)) {
			Toast.makeText(this, "输入不能为空", 1).show();
			return false;
		}
		if (Integer.parseInt(max) > Integer.parseInt(min)
				&& Integer.parseInt(max) >= Integer.parseInt(current)
				&& Integer.parseInt(current) >= Integer.parseInt(min)
				&& Integer.parseInt(min) >= 10 && Integer.parseInt(max) <= 40) {
			flag = true;
		} else {
			Toast.makeText(this, "输入有误", 1).show();
			flag = false;
		}
		return flag;

	}

}
