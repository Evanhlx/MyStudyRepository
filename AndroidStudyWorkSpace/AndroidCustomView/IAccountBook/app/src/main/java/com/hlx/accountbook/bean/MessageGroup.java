package com.hlx.accountbook.bean;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MessageGroup implements Comparable<MessageGroup> {

    public ArrayList<Message> msgList = new ArrayList<>();

    private Message lastMessage;

    public Account account = new Account();

    private boolean isSort = false;

    public Message getLastMessage() {
        if (msgList.size() > 0) {
            if (!isSort) {
                Collections.sort(msgList);
                isSort = true;
            }
            lastMessage = msgList.get(msgList.size() - 1);
//            lastMessage = new Message(lastMessage.body,lastMessage.date,lastMessage.number,lastMessage.number);
        } else {
            return new Message("", 0L, "", "");
        }
        return lastMessage;
    }


    @Override
    public int compareTo(@NonNull MessageGroup o) {

        if (parseDate(this.account.date) > parseDate(o.account.date)) {
            return 1;
        } else if (parseDate(this.account.date) < parseDate(o.account.date)) {
            return -1;
        }
        return 0;


       /* if(this.getLastMessage().longDate > o.getLastMessage().longDate){
            return -1;
        }else if(this.getLastMessage().longDate < o.getLastMessage().longDate){
            return 1;
        }
        return 0;*/
    }

    private Long parseDate(String datestr) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        Date date = null;
        try {
            date = format.parse(datestr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date != null ? date.getTime() : 0;
    }
}
