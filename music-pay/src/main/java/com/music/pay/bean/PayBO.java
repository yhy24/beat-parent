package com.music.pay.bean;

import java.io.Serializable;

/**
 * @author yhy
 */
public class PayBO implements Serializable {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
