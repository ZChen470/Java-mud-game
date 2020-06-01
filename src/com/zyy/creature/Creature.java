package com.zyy.creature;

import com.zyy.Room;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 11:11
 * @discription: 生物类
 */
public abstract class Creature {
    private String id;
    private String name;
    private Room currentRoom;
    private int DNA, HP, ATK, DEF; //攻击力和防御力

    public Creature() {
    }

    public Creature(String id, String name, int DNA, int HP, int ATK, int DEF) {
        this.id = id;
        this.name = name;
        this.DNA = DNA;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getDNA() {
        return DNA;
    }

    public void setDNA(int DNA) {
        this.DNA = DNA;
    }

    public int getHP() {
        if (HP < 0){
            return 0;
        }
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public abstract void attack(Creature creature);
}
