package com.example.arouterdemo.ui.text;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.arouterdemo.R;

import java.util.Date;

/**
 * @author: xiewenliang
 * @Filename:
 * @Description:
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/4/19 10:47
 */
@Route(path = "/ui/text", group = "文本")
public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        String str = getIntent().getStringExtra("arg1");
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(R.id.textView)).setText(str);
        }
    }

    @Override
    public void finish() {
        setResult(1002, getIntent().putExtra("arg2", new Date().toString()));
        super.finish();
    }
}
