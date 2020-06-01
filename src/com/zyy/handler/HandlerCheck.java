package com.zyy.handler;

import com.zyy.Ui;
import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 18:00
 * @discription:
 */
public class HandlerCheck extends Handler{
    public HandlerCheck(Ui ui) {
        super(ui);
    }
    @Override
    public void doCmd(String word) {
        Person.getPerson().showBag();
    }
}
