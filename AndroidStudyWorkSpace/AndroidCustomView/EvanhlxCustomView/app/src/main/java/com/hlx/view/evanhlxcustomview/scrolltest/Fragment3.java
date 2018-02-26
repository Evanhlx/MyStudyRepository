package com.hlx.view.evanhlxcustomview.scrolltest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.hlx.view.evanhlxcustomview.R;
import com.hlx.view.evanhlxcustomview.view.CustomBroadcastScrollView;

/**
 * Created by Administrator on 2018/1/26/026.
 */

public class Fragment3 extends Fragment {

    String img00 = "http://image5.tuku.cn/pic/wallpaper/fengjing/menghuandaziranmeijingbizhi/009.jpg";
    String img01 = "http://s1.dwstatic.com/group1/M00/69/60/69604facab765a94902964c2575960bc3373.jpg";
    String img02 = "http://s1.dwstatic.com/group1/M00/33/39/80f46083adee4ecefb1ae2216672d5c3.jpg";
    String img03 = "http://s1.dwstatic.com/group1/M00/A4/D2/a4d2823812fb5b8dab6132448ef2a4bf4211.jpg";
    String img04 = "http://s1.dwstatic.com/group1/M00/8B/36/8b3607957efa4ad7b8e1925ede5a44302748.jpg";
    String img05 = "http://s1.dwstatic.com/group1/M00/DC/3A/dc3a65e81578ead18041523ccd443a259347.jpg";
    private String[] images = {img00, img01, img02, img03, img04, img05,};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_three, container, false);
//        ImageView imgView = view.findViewById(R.id.img00);
//        Uri uri = Uri.parse("http://image5.tuku.cn/pic/wallpaper/fengjing/menghuandaziranmeijingbizhi/009.jpg");
//        Glide.with(this).load("http://pic1.sc.chinaz.com/files/pic/pic9/201801/zzpic9787.jpg").placeholder(R.mipmap.mayun01).into(imgView);
        CustomBroadcastScrollView imgContainer = view.findViewById(R.id.img_container);
        for (int i = 0; i < imgContainer.getChildCount(); i++) {
            int img_index = i;
            if (img_index >= images.length) {
                img_index = images.length - 1;
            }
            Glide.with(this).load(images[img_index]).into((ImageView) imgContainer.getChildAt(i));
        }
        return view;
    }

}
