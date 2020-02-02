/*
 * Copyright (c) 2020. 526892120@qq.com
 */

package com.example.android.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.bluetoothchat.R;

import java.util.List;

/**
 * 聊天信息适配器
 */
public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    private int resourceId;

    /**
     * 构造函数
     * @param context Context
     * @param resource Resource
     * @param objects Objects
     */
    public ChatMessageAdapter(Context context, int resource, List<ChatMessage> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /* return super.getView(position, convertView, parent); */
        ChatMessage msg = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        if (msg.getType() == ChatMessage.TYPE_RECEIVED) {
            //如果是收到消息，就显示左边的布局，隐藏右边的消息布局
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == ChatMessage.TYPE_SENT) {
            //如果是发送，就显示右边的布局，隐藏左边的消息布局
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return view;
    }

    /**
     * 列表子项实例类
     */
    class ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}