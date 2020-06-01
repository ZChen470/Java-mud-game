package com.zyy.handler;

import com.zyy.Ui;
import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 0:24
 * @discription:
 */
public class HandlerGo extends Handler{
    public HandlerGo(Ui ui) {
        super(ui);
    }

    @Override
    public void doCmd(String word) {
        System.out.println("正在前往...");
        ui.proStop(2000);
        Person.getPerson().goRoom(word);
        ui.showPrompt(Person.getPerson());
    }
}
