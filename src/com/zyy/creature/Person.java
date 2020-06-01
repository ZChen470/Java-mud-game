package com.zyy.creature;

import com.zyy.Room;
import com.zyy.props.Props;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 12:05
 * @discription: 玩家生物
 */
public class Person extends Creature{
    private int LV = 0;
    private Props currentArmor = null;
    private Props currentWeapon = null;
    private int contATK, contDEF;
    private HashMap<String, Props> bag = new HashMap<String, Props>();

    private static Person person = new Person("100","name",0,200, 20, 10);
    private Person(String id, String name, int DNA, int HP, int ATK, int DEF)
    {
        super(id, name, DNA, HP, ATK, DEF);
        this.contATK = ATK;
        this.contDEF = DEF;
    }

    public HashMap<String, Props> getBag() {
        return bag;
    }

    public void upLevel(int DNA) {
        System.out.println("你获得了" + DNA + "点DNA");
        setDNA(getDNA() + DNA);
        LV = getDNA()/100;
        contATK += 1;
        contDEF += 1;
        setHP(getHP() + 10);
        setATK(getATK() + 1);
        setDEF(getDEF() + 1);
        System.out.println("你升级了，当前等级为:" + "Lv" + LV + "\n攻击力提升1\n防御力提升1\n生命值恢复10" +"\n经过漫长的优胜劣汰后，你的种群会变得和你一样强大");
        if (LV >= 10) {
            System.out.println("恭喜你！在经过激烈的竞争后，你成功打败了所有竞争者，使你的种群成功进化，");
            System.out.println("现在你的种群已经到达食物链的顶端，成为盘古超大陆的最强生物！");
            System.out.println("然而，在这片古老的大陆上，生物的进化一刻也没有停止......");
        }
    }

    public static Person getPerson() {
        return person;
    }
    public void attack(Creature creature){
        creature.setHP(creature.getHP() - getATK() + creature.getDEF());
    }

    public void goRoom(String direction)
    {
        Room nextRoom = getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("那里没路！");
        }
        else {
            System.out.println("成功到达目的地");
            setCurrentRoom(nextRoom);
        }
    }

    public void getProps(String name, Props props) {
        bag.put(name, props);
        System.out.println("你获得了" + name);
    }

    public  int getContATK() {
        return contATK;
    }

    public  int getContDEF() {
        return contDEF;
    }


    //展示玩家生物参数
    public void showPerson() {
        System.out.println("ID：" + getId());
        System.out.println("名字：" + getName());
        System.out.println("等级：" + LV);
        System.out.println("血量：" + getHP());
        System.out.println("攻击力：" + getATK());
        System.out.println("防御力：" + getDEF());
        System.out.println("DNA点数：" + getDNA());
    }


    //展示背包物品参数
    public void showBag() {
        List<Props> valueList = new ArrayList<Props>(bag.values());
        for (Props props : valueList) {
            System.out.print("ID；" + props.getId());
            System.out.print("\t物品名称：" + props.getName() + "\t\t");
            System.out.println(props.toString() + props.getEffect());
        }
    }

    //根据ID使用道具
    public void useProps(String word) {
        int flag = 0;
        int propsID = Integer.parseInt( word );
        List<Props> valueList = new ArrayList<Props>(bag.values());
        for (Props props : valueList) {
            if (word.equals(props.getId())) {
                if (211 <= propsID && propsID <= 212) {
                    if (currentWeapon != null) {
                        getProps(currentWeapon.getName(), currentWeapon);
                    }
                    currentWeapon = props;
                    currentWeapon.useProps(this);
                    flag++;
                    bag.remove(currentWeapon.getName());   //通过键删除哈希表的键值对
                    System.out.println("你的" + currentWeapon.toString() + currentWeapon.getEffect() + "，当前攻击力为" + getATK());
                } else if (221 <= propsID && propsID <= 222) {
                    if (currentArmor != null) {
                        getProps(currentArmor.getName(), currentArmor);
                    }
                    currentArmor = props;
                    currentArmor.useProps(this);
                    flag++;
                    bag.remove(currentArmor.getName());
                    System.out.println("你的" + currentArmor.toString() + currentArmor.getEffect() + "，当前防御力为" + getDEF());
                } else if (201 <= propsID && propsID <= 202) {
                    props.useProps(this);
                    flag++;
                    bag.remove(props.getName());
                    System.out.println("你的" + props.toString() + props.getEffect() + "，当前生命值为" + getHP());
                }
            }
        }
        if (flag == 0) {
            System.out.println("当前背包尚无此物品");
        }
    }
}
