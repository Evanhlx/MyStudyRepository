package com.hlx.accountbook.sms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlx.accountbook.R;
import com.hlx.accountbook.bean.MessageGroup;

import java.util.List;

/**
 * Created by Administrator on 2018/1/22/022.
 */

public class SmsGroupAdapter extends RecyclerView.Adapter<SmsGroupAdapter.SmsViewHolder> {

    private Context mContext;
    private List<MessageGroup> mDatas;
    private OnSmsGroupItemClickListener listener;

    public SmsGroupAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<MessageGroup> datas) {
        this.mDatas = datas;
    }

    public void setSmsGroupItemClickListener(OnSmsGroupItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public SmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_list_item, parent,false);
        SmsViewHolder holder = new SmsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final SmsViewHolder holder, final int position) {
        holder.bank.setText(mDatas.get(position).account.bank);
        holder.date.setText(mDatas.get(position).account.date);
        holder.account.setText(mDatas.get(position).account.curAccount);
        holder.cardNum.setText(mDatas.get(position).account.cardNum);
        holder.item = mDatas.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,holder.item);
            }
        });
    }


    @Override
    public int getItemCount() {
        return null != mDatas ? mDatas.size() : 0;
    }

    class SmsViewHolder extends RecyclerView.ViewHolder {
        TextView bank;
        TextView date;
        TextView account;
        TextView cardNum;
        View itemView;
        MessageGroup item;

        public SmsViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            bank = itemView.findViewById(R.id.bank);
            date = itemView.findViewById(R.id.date);
            account = itemView.findViewById(R.id.account);
            cardNum = itemView.findViewById(R.id.card_num);
        }
    }

    public interface OnSmsGroupItemClickListener{
        void onItemClick(View v,MessageGroup item);
    }

}

