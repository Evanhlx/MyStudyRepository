package com.hlx.accountbook;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/22/022.
 */

public class Message {
    public String number;
    public String date;
    public String body;
    public String person;

    public Message(String body, String date, String number, String person) {
        this.body = body;
        this.number = number;
        this.person = person;
        parserDate(date);
    }

    private void parserDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.date = formatter.format(new Date(new Long(date)));
    }
}
