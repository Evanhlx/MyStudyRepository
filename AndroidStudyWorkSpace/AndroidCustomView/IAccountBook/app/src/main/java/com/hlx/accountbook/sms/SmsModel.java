package com.hlx.accountbook.sms;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.hlx.accountbook.App;
import com.hlx.accountbook.bean.Account;
import com.hlx.accountbook.bean.Message;
import com.hlx.accountbook.bean.MessageGroup;
import com.hlx.accountbook.common.Constans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by huanglx on 2018/6/2.
 */

public class SmsModel implements ISmsModel {


    /**
     * final String SMS_URI_INBOX = "content://sms/inbox";
     * final String SMS_URI_SEND = "content://sms/sent";
     * final String SMS_URI_DRAFT = "content://sms/draft";
     *
     * @return 处理后的短信集合
     */
    @Override
    public List<MessageGroup> getMassages(ContentResolver resolver) {
        Map<String, MessageGroup> groupMap = getMessageGroupMap(resolver);
        ArrayList<MessageGroup> groupList = new ArrayList<>(groupMap.values());
        Collections.sort(groupList);

        return groupList;
    }

    /**
     * 1，按月份类计算消费或这账单
     * 2，
     *
     * @param resolver
     * @return
     */
    @NonNull
    private Map<String, MessageGroup> getMessageGroupMap(ContentResolver resolver) {
        MessageGroup msgGroup = null;
        Message msg = null;
        Map<String, MessageGroup> msgMap = new HashMap<>();

        try {
            Uri sms_inbox = Uri.parse("content://sms/inbox");
            String[] projection = new String[]{"_id", "address", "person", "body", "date", "type"};
            Cursor smsCursor = resolver.query(sms_inbox, projection, null, null, "date desc");
            Log.i("sms", "------- sms cursor is start -------");
            if (null != smsCursor) {
                List bankNums = Arrays.asList(Constans.BANK_NUMS);
                while (smsCursor.moveToNext()) {
                    String number = smsCursor.getString(smsCursor.getColumnIndex("address"));
                    String body = smsCursor.getString(smsCursor.getColumnIndex("body")).trim();
                    Long date = smsCursor.getLong(smsCursor.getColumnIndex("date"));
                    String person = smsCursor.getString(smsCursor.getColumnIndex("person"));
                    Log.i("sms", "number : " + number + " date : " + date);
                    msg = new Message(body, date, number, person);
                    Log.i("sms", "sms date : " + msg.date);
                    // 过滤 指定 的数据
                    if (bankNums.size() > 0 && !bankNums.contains(msg.number)) continue;
                    if (msgMap.containsKey(msg.number)) {
                        msgMap.get(msg.number).msgList.add(msg);
                    } else {
                        msgGroup = new MessageGroup();
                        msgGroup.msgList.add(msg);
                        msgMap.put(msg.number, msgGroup);
                    }
                    msgMap.get(msg.number).account.parseAccount(body, number,date);
                }
            } else {
                Log.i("sms", "------- sms cursor is null -------");
            }

//            dealMessages(messages);
            //在用managedQuery的时候，不能主动调用close()方法， 否则在Android 4.0+的系统上， 会发生崩溃
            if (Build.VERSION.SDK_INT < 14) {
                smsCursor.close();
            }
        } catch (Exception e) {
            Toast.makeText(App.getInstance(), e == null ? "sms error" : e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return msgMap;
    }

    /**
     * 处理短信内容，只要现实我们需要指定的短信内容
     *
     * @param msgGroups
     */
    private ArrayList<MessageGroup> dealMessages(Map<String, MessageGroup> msgGroups) {
        final ArrayList<MessageGroup> subMessages = new ArrayList<>();

        Observable.fromIterable(msgGroups.values()).filter(new Predicate<MessageGroup>() {

            @Override
            public boolean test(MessageGroup messageGroup) throws Exception {
                List bankNums = Arrays.asList(Constans.BANK_NUMS);
                return (bankNums.contains(messageGroup.getLastMessage().number));
            }
        }).subscribe(new Consumer<MessageGroup>() {

            @Override
            public void accept(MessageGroup messageGroup) throws Exception {
                subMessages.add(messageGroup);
            }
        });

        return subMessages;
    }
}
