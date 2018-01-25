package com.hlx.accountbook;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2018/1/22/022.
 */

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.SmsViewHolder> {

    private Context mContext;
    private ArrayList<Message> mDatas;

    public SmsAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(ArrayList<Message> datas) {
        this.mDatas = datas;
    }

    @Override
    public SmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_list_item, parent,false);
        SmsViewHolder holder = new SmsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(SmsViewHolder holder, int position) {
        holder.body.setText(mDatas.get(position).body);
        holder.date.setText(mDatas.get(position).date);
        holder.number.setText(mDatas.get(position).number);
        holder.person.setText(mDatas.get(position).person);
    }


    @Override
    public int getItemCount() {
        return null != mDatas ? mDatas.size() : 0;
    }

    class SmsViewHolder extends RecyclerView.ViewHolder {
        TextView body;
        TextView date;
        TextView number;
        TextView person;

        public SmsViewHolder(View itemView) {
            super(itemView);
            body = itemView.findViewById(R.id.body);
            date = itemView.findViewById(R.id.date);
            number = itemView.findViewById(R.id.number);
            person = itemView.findViewById(R.id.person);
        }
    }
}

