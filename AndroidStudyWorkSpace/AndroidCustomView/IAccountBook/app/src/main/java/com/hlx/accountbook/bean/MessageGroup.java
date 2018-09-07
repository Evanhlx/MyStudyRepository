package com.hlx.accountbook.bean;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class MessageGroup implements Comparable<MessageGroup>{

    public ArrayList<Message> msgList = new ArrayList<>();

    private Message lastMessage ;

    public Account account = new Account();

    private boolean isSort = false;

    public Message getLastMessage() {
        if(msgList.size() > 0){
            if(!isSort){
                Collections.sort(msgList);
                isSort = true;
            }
            lastMessage = msgList.get(msgList.size()-1);
//            lastMessage = new Message(lastMessage.body,lastMessage.date,lastMessage.number,lastMessage.number);
        }else {
            return new Message("",0L,"","");
        }
        return lastMessage;
    }


    @Override
    public int compareTo(@NonNull MessageGroup o) {
        if(this.getLastMessage().longDate > o.getLastMessage().longDate){
            return -1;
        }else if(this.getLastMessage().longDate < o.getLastMessage().longDate){
            return 1;
        }
        return 0;
    }
}
