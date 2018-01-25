package com.hlx.accountbook;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Message> mMessages = new ArrayList<Message>();
    private SmsAdapter mAdapter;
    private static final int REQUEST_CODE = 10034;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        if (null != getSupportActionBar()){
            getSupportActionBar().hide();
        }

        initView();
        checkSmsPermission();
    }

    private void checkSmsPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_SMS)){
                initSms();
            }else{
                Toast.makeText(getApplicationContext(),"READ_SMS permission is not allow !",Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS},REQUEST_CODE);
            }
        }else{
            initSms();
        }
    }

    private void initSms() {
        Toast.makeText(getApplicationContext(),"initSms start !",Toast.LENGTH_SHORT).show();
        try{
            Uri sms_inbox = Uri.parse("content://sms/");
//            final String SMS_URI_INBOX = "content://sms/inbox";
//            final String SMS_URI_SEND = "content://sms/sent";
//            final String SMS_URI_DRAFT = "content://sms/draft";
            ContentResolver mResolver = getContentResolver();
            String[] projection = new String[]{"_id","address","person","body","date","type"};
            Cursor smsCursor = mResolver.query(sms_inbox,projection,null,null,"date desc");
            Log.i("sms","------- sms cursor is start -------");
            if(null!=smsCursor){
                while (smsCursor.moveToNext()){
                    String number = smsCursor.getString(smsCursor.getColumnIndex("address"));
                    String body = smsCursor.getString(smsCursor.getColumnIndex("body")).trim();
                    String date = smsCursor.getString(smsCursor.getColumnIndex("date"));
                    String person = smsCursor.getString(smsCursor.getColumnIndex("person"));
                    Log.i("sms","number : "+number+" date : "+date);
                    Message msg = new Message(body,date,number,person);
                    mMessages.add(msg);
                }
                initData();
            }else{
                Log.i("sms","------- sms cursor is null -------");
            }
            //在用managedQuery的时候，不能主动调用close()方法， 否则在Android 4.0+的系统上， 会发生崩溃
            if(Build.VERSION.SDK_INT < 14) {
                smsCursor.close();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

    RecyclerView mRecyclerView;
    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mAdapter = new SmsAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        mAdapter.setData(mMessages);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_CODE:
                if(grantResults.length >0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initSms();
                }else{
                    Toast.makeText(getApplicationContext(),"READ_SMS permission is not allow !",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
