package com.example.androidmyview;

import android.content.Context;

public class MeasureUtil {
	public static int getScreenWidth(Context mContext) {
		int width = mContext.getResources().getDisplayMetrics().widthPixels;
		return width;
	}

	public static int getScreenHeight(Context mContext) {
		int height = mContext.getResources().getDisplayMetrics().heightPixels;
		return height;
	}
}
