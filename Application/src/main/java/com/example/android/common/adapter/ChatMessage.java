/*
 * Copyright (c) 2020. 526892120@qq.com
 */

package com.example.android.common.adapter;

public class ChatMessage {

    /**
     * type sent
     */
    public static final int TYPE_SENT = 1;

    /**
     * type received
     */
    public static final int TYPE_RECEIVED = 2;

    private int mType;

    private String mContent;

    /**
     * get Content
     * @return
     */
    public String getContent() {
        return mContent;
    }

    /**
     * set content
     * @param content
     */
    public void setmContext(String content) {
        this.mContent = content;
    }

    /**
     * get Message Type
     * @return
     */
    public int getType() {
        return mType;
    }

    /**
     * set Message Type
     * @param type
     */
    public void setmMessgeType(int type) {
        this.mType = type;
    }
}
