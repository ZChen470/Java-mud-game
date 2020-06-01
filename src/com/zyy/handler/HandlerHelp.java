package com.zyy.handler;

import com.zyy.Ui;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/30 - 0:30
 * @discription:
 */
public class HandlerHelp extends Handler{
    public HandlerHelp(Ui ui) {
        super(ui);
    }
    @Override
    public void doCmd(String word) {
        System.out.println("你可以做的命令有：\ngo:前往其他地方 如：go east \nhelp：查看指令 \nview：查看你的生物参数");
        System.out.println("check：查看背包物品参数\nuse：使用背包中的道具 如：use 201 \ncombat：和怪物进行战斗 \nbye：退出游戏");
    }
}
