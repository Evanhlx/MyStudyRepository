package com.hlx.accountbook.sms;

import android.content.ContentResolver;

import com.hlx.accountbook.bean.MessageGroup;

import java.util.List;

/**
 * Created by huanglx on 2018/6/2.
 * 准备 短信 的数据。做数据的 获取 处理等。
 */

public interface ISmsModel {

    List<MessageGroup> getMassages(ContentResolver resolver);
}
