package com.zyy.handler;

import com.zyy.Ui;
import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 18:19
 * @discription:
 */
public class HandlerUse extends Handler{
    public HandlerUse(Ui ui) {
        super(ui);
    }
    @Override
    public void doCmd(String word) {
        Person.getPerson().useProps(word);
    }
}
