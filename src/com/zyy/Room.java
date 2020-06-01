package com.zyy;

import com.zyy.creature.Monster;

import java.util.HashMap;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 11:14
 * @discription:
 */
public class Room {
    private String description;
    private Monster monster;
    private boolean withLiving = true;
    private HashMap<String, Room> exits = new HashMap<String, Room>();

    public Room(String description, Monster monster) {
        this.description = description;
        this.monster = monster;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    @Override
    public String toString() {
        return this.description;
    }

    //获得房间出口的描述
    public String getExitDescrip() {
        StringBuffer sb = new StringBuffer();
        for (String direction : exits.keySet()) {
            sb.append(direction);
            sb.append(" ");
        }

        return sb.toString();
    }

    //通过方向获得出口房间
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public boolean isWithLiving() {
        return withLiving;
    }

    public void setWithLiving(boolean withLiving) {
        this.withLiving = withLiving;
    }

    public Monster getMonster() {
        return monster;
    }
}
