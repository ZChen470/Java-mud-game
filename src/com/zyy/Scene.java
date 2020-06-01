package com.zyy;

import com.zyy.creature.Monster;
import com.zyy.creature.Person;
import com.zyy.props.Armor;
import com.zyy.props.Props;
import com.zyy.props.Regeneration;
import com.zyy.props.Weapon;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 22:48
 * @discription: 创建场景
 */
public class Scene {
    Person person = Person.getPerson();
    Room birthPlace,forest,canyon,prairie,desert;
    Monster  mon1, mon2, mon3, mon4, mon5;
    Props weapon1, weapon2, regeneration1, regeneration2, armor1, armor2;
    public Scene() {
    }

    public void initScene() {
        this.creatProps();
        this.creatMonsters();
        this.creatRooms();
    }

    public void creatProps() {
        weapon1 = new Weapon("211", "螺旋角", 5);
        weapon2 = new Weapon("212", "毒尾节", 8);
        regeneration1 = new Regeneration("201", "生命果实", 60);
        regeneration2 = new Regeneration("202", "能量豆", 80);
        armor1 = new Armor("221", "平骨鳞片", 5);
        armor2 = new Armor("222", "疣突鳞片", 3);

        person.getProps(regeneration1.getName(), regeneration1);
    }

    public void creatMonsters() {
        mon1 = new Monster("101", "蓝纹鸭", 100, 90, 15, 5);
        mon1.setProps(regeneration2);
        mon2 = new Monster("102", "芒刺猩猩",210, 120, 20, 10);
        mon2.setProps(armor1);
        mon3 = new Monster("103", "山羊狗", 180,100, 15, 10);
        mon3.setProps(weapon1);
        mon4 = new Monster("104", "乳牛怪", 240,120, 20, 15);
        mon4.setProps(armor2);
        mon5 = new Monster("105", "三头鸟", 270,150, 25, 15);
        mon5.setProps(weapon2);
    }

    private void creatRooms() {

        //制造房间
        birthPlace = new Room("出生地", mon1);
        forest = new Room("暮色森林", mon2);
        canyon = new Room("幽暗峡谷", mon3);
        prairie = new Room("苍茫草原", mon4);
        desert = new Room("寂静沙漠", mon5);

        birthPlace.setExit("east", prairie);
        birthPlace.setExit("north", canyon);
        birthPlace.setExit("west", forest);
        forest.setExit("south", birthPlace);
        forest.setExit("east", canyon);
        canyon.setExit("south", birthPlace);
        canyon.setExit("west", forest);
        canyon.setExit("east", prairie);
        canyon.setExit("north", desert);
        prairie.setExit("south", birthPlace);
        prairie.setExit("west", canyon);
        desert.setExit("south", canyon);

        this.person.setCurrentRoom(birthPlace);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
