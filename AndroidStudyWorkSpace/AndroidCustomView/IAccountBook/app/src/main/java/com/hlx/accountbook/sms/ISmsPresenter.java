package com.hlx.accountbook.sms;

import android.content.ContentResolver;

import com.hlx.accountbook.bean.MessageGroup;

import java.util.List;

/**
 * Created by huanglx on 2018/6/2.
 */

public interface ISmsPresenter {

    List<MessageGroup> getMessageGroup(ContentResolver resolver);
}
