package com.hlx.accountbook.sms;

import android.content.ContentResolver;

import com.hlx.accountbook.bean.MessageGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanglx on 2018/6/2.
 */

public class SmsPresenter implements ISmsPresenter{
    private SmsModel smsModel;
    public SmsPresenter(){
        smsModel = new SmsModel();
    }
    @Override
    public List<MessageGroup> getMessageGroup(ContentResolver resolver) {

        return smsModel.getMassages(resolver);
//        return  testModle();
    }

    private List<MessageGroup> testModle(){
        List<MessageGroup> msgs = new ArrayList<>();

        for(int i = 0;i < 15;i++){
            msgs.add(new MessageGroup());
        }

        return msgs;
    }
}
