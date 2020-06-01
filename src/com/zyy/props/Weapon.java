package com.zyy.props;

import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 20:40
 * @discription: 武器类
 */
public class Weapon extends Props{
    private String description = "攻击力提升：";

    public Weapon(String id, String name, int effect) {
        super(id, name, effect);
    }

    public void useProps(Person person)
    {
        person.setATK(person.getContATK() + getEffect());
    }

    @Override
    public String toString() {
        return description;
    }
}
