package com.zyy.props;

import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 20:51
 * @discription: 防具
 */
public class Armor extends Props{
    private String description = "防御力提升：";

    public Armor(String id, String name, int effect) {
        super(id, name, effect);
    }

    public void useProps(Person person)
    {
        person.setDEF(person.getContDEF() + getEffect());
    }

    @Override
    public String toString() {
        return description;
    }
}
