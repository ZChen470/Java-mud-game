package com.zyy.handler;

import com.zyy.Ui;
import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 19:47
 * @discription:
 */
public class HandlerCombat extends Handler{
    public HandlerCombat(Ui ui) {
        super(ui);
    }
    @Override
    public void doCmd(String word) {
        if (Person.getPerson().getCurrentRoom().isWithLiving()) {
            ui.showDuel();
        } else {
            System.out.println("这里什么也没有...");
        }
    }
}
