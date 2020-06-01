package com.zyy.handler;

import com.zyy.Ui;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 0:18
 * @discription:
 */
public class Handler {
    protected Ui ui;

    public Handler(Ui ui) {
        this.ui = ui;
    }
    public void doCmd(String word) {
    }
    public boolean isBye() {
        return false;
    }
}
