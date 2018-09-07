package com.hlx.accountbook;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.hlx.accountbook.bean.Message;
import com.hlx.accountbook.bean.MessageGroup;
import com.hlx.accountbook.sms.SmsDetailActivity;
import com.hlx.accountbook.sms.SmsGroupAdapter;
import com.hlx.accountbook.sms.SmsItemFragment;
import com.hlx.accountbook.sms.SmsPresenter;
import com.hlx.accountbook.widget.icon.ArrowDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements SmsGroupAdapter.OnSmsGroupItemClickListener, SmsItemFragment.OnListFragmentInteractionListener, View.OnClickListener {

    private String TAG = MainActivity.class.getName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;
    private SmsGroupAdapter mAdapter;
    private static final int REQUEST_CODE = 10034;

    private SmsPresenter mSmsPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        if (null != getSupportActionBar()) getSupportActionBar().hide();
        setToolbar();
        mSmsPresenter = new SmsPresenter();
        initView();
        checkSmsPermission();
    }

    private void setToolbar() {
        mToolbar.setTitle("信用卡中心");
        mToolbar.setTitleTextColor(Color.parseColor("#393838"));
        mToolbar.setNavigationIcon(new ArrowDrawable());
        mToolbar.setNavigationOnClickListener(this);
//        mToolbar.setSubtitle("账单统计");

        setSupportActionBar(mToolbar);
    }

    private void checkSmsPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS)) {
                initData();
            } else {
                Toast.makeText(getApplicationContext(), "READ_SMS permission is not allow !", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, REQUEST_CODE);
            }
        } else {
            initData();
        }
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new SmsGroupAdapter(this);
        mAdapter.setSmsGroupItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mAdapter.setData(mSmsPresenter.getMessageGroup(getContentResolver()));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initData();
                } else {
                    Toast.makeText(getApplicationContext(), "READ_SMS permission is not allow !", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    @Override
    public void onItemClick(View v, MessageGroup item) {
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment_container, SmsItemFragment.newInstance(item.msgList))
//                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//                .addToBackStack("")
//                .commit();
        Intent intent = new Intent(this, SmsDetailActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
            overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
        }
    }

    @Override
    public void onListFragmentInteraction(Message item) {

    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: "+v.getId());
//        finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.d(TAG, "onPointerCaptureChanged: "+hasCapture);
        finish();
    }
}
