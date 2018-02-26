package com.hlx.view.evanhlxcustomview.scrolltest;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.view.ViewGroup.LayoutParams;

import com.bumptech.glide.Glide;
import com.hlx.view.evanhlxcustomview.R;
import com.hlx.view.evanhlxcustomview.view.CusScrollView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class ScrollTest3Activity extends AppCompatActivity {
    String img00 = "http://image5.tuku.cn/pic/wallpaper/fengjing/menghuandaziranmeijingbizhi/009.jpg";
    String img01 = "http://s1.dwstatic.com/group1/M00/69/60/69604facab765a94902964c2575960bc3373.jpg";
    String img02 = "http://s1.dwstatic.com/group1/M00/33/39/80f46083adee4ecefb1ae2216672d5c3.jpg";
    String img03 = "http://s1.dwstatic.com/group1/M00/A4/D2/a4d2823812fb5b8dab6132448ef2a4bf4211.jpg";
    String img04 = "http://s1.dwstatic.com/group1/M00/8B/36/8b3607957efa4ad7b8e1925ede5a44302748.jpg";
    String img05 = "http://s1.dwstatic.com/group1/M00/DC/3A/dc3a65e81578ead18041523ccd443a259347.jpg";
    private String[] images = {img00, img01, img02, img03,
            img04, img05,};
    private int[] images2 = {R.mipmap.timg, R.mipmap.timg1, R.mipmap.timg2,
            R.mipmap.timg4, R.mipmap.timg5, R.mipmap.timg6};

    private CusScrollView mCusScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test3);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        mCusScrollView = (CusScrollView) this.findViewById(R.id.CusScrollView);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                setImage();
            }
        }).start();

//        setImage2();
        setImage3();
    }

    private void setImage2() {
        for (int i = 0; i < images.length; i++) {
            ImageView mImageView = new ImageView(this);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageView.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            Glide.with(this).load(images[i]).into(mImageView);
            mCusScrollView.addView(mImageView);
        }
    }

    private void setImage3() {
        for (int i = 0; i < images2.length; i++) {
            ImageView mImageView = new ImageView(this);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageView.setBackgroundResource(images2[i]);
            mImageView.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            mCusScrollView.addView(mImageView);
        }
    }

    private void setImage() {
        for (int i = 0; i < images.length; i++) {
            final ImageView mImageView = new ImageView(this);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            mImageView.setBackgroundResource(images[i]);
            try {
//                mImageView.setImageBitmap(BitmapFactory.decodeStream(new URL(images[i]).openStream()));

                HttpURLConnection connection = (HttpURLConnection) new URL(images[i]).openConnection();
                connection.setConnectTimeout(6000);
                connection.setDoInput(true);
                connection.setUseCaches(false);
                InputStream input = connection.getInputStream();

                mImageView.setImageBitmap(BitmapFactory.decodeStream(input));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            mImageView.setLayoutParams(new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mCusScrollView.addView(mImageView);
                }
            });
        }
    }
}
