package com.manymore13.scrollerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{

	private Button btnBelow,btnAbove;
	private TextView tvHint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnBelow = (Button)this.findViewById(R.id.btn_Below);
		btnAbove = (Button)this.findViewById(R.id.btn_above);
		tvHint   = (TextView)this.findViewById(R.id.tv_hint);
		btnBelow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this, "这是下面一层按钮", 1000).show();
			}
		});

		btnAbove.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this, "这是上面一层按钮", 1000).show();

			}
		});

		Animation ani = new AlphaAnimation(0f,1f);
		ani.setDuration(1500);
		ani.setRepeatMode(Animation.REVERSE);
		ani.setRepeatCount(Animation.INFINITE);
		tvHint.startAnimation(ani);
	}

	int lastDownY = 0;

}
