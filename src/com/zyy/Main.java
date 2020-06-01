package com.zyy;

import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 12:18
 * @discription: 主程序 - 832
 */

public class Main{
    public static void main(String[] args){
            Ui ui = new Ui();
            ui.printWelcome(Person.getPerson());
            ui.play();
            System.out.println("感谢您的游玩，再见！");
        }
}

