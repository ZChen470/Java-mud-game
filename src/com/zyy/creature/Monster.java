package com.zyy.creature;

import com.zyy.props.Props;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 21:09
 * @discription: 敌对生物
 */
public class Monster extends Creature{
    private Props props;

    public Monster(String id, String name, int DNA, int HP, int ATK, int DEF) {
        super(id, name, DNA, HP, ATK, DEF);
//        this.props = props;
    }

    public void attack(Creature creature)
    {
        creature.setHP(creature.getHP() - getATK() + creature.getDEF());
    }

    public void setProps(Props props) {
        this.props = props;
    }

    public Props getProps() {
        return props;
    }

    @Override
    public String toString() {
        return getName();
    }
}
