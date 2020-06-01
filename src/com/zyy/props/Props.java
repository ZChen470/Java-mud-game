package com.zyy.props;

import com.zyy.creature.Person;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 12:16
 * @discription: 道具类
 */
public abstract class Props {
    private String id;
    private String name;
    private int effect;

    public Props(){

    }

    public Props(String id, String name, int effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
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

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public abstract void useProps(Person person);
}
