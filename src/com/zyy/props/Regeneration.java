package com.zyy.props;

import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 20:40
 * @discription: 生命值恢复道具
 */
public class Regeneration extends Props{
    private String description = "生命点数恢复：";

    public Regeneration(String id, String name, int effect) {
        super(id, name, effect);
    }

    public void useProps(Person person)
    {
        person.setHP(person.getHP() + getEffect());
    }

    @Override
    public String toString() {
        return description;
    }
}
