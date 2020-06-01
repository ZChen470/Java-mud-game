package com.zyy.handler;

import com.zyy.Ui;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 0:23
 * @discription:
 */
public class HandlerBye extends Handler{
    public HandlerBye(Ui ui) {
        super(ui);
    }
    @Override
    public boolean isBye() {
        return true;
    }
}
