package com.zyy;

import com.zyy.handler.*;
import com.zyy.creature.Monster;
import com.zyy.creature.Person;

import java.util.Scanner;
import java.util.HashMap;

/**
 * @author: 周宇洋 201902200
 * @date: 2020/5/29 - 23:54
 * @discription: 运行界面
 */
public class Ui extends Thread{
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

    public Ui() {
        Scene scene = new Scene();
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        handlers.put("go", new HandlerGo(this));
        handlers.put("view", new HandlerView(this));
        handlers.put("use", new HandlerUse(this));
        handlers.put("combat", new HandlerCombat(this));
        handlers.put("check", new HandlerCheck(this));
        scene.initScene();
    }

    public static void printWelcome(Person person) {
        System.out.println("---------------------------------------------");
        System.out.println("欢迎游玩《进化》");
        System.out.println("在一亿五千万年前的盘古超大陆，你的种族刚刚进化为陆地生物。");
        System.out.println("而你要做的，就是通过进化让自己的种族在残酷的竞争中变得越来越强大，");
        System.out.println("直至到达食物链的顶端，从而使种族延续下去...");
        System.out.println("---------------------------------------------");
        System.out.println("您可以通过输入指令的方式来进行游玩");
        System.out.println("如果需要帮助，请输入‘help’");
        System.out.println("-------------------------");
        System.out.print("为你的生物命名：");
        Scanner on = new Scanner(System.in);
        String setname = on.nextLine();
        Person.getPerson().setName(setname);
        System.out.println("-----------------------");
        showPrompt(person);
    }

    public static void showPrompt(Person person) {
        Monster monster = person.getCurrentRoom().getMonster();
        System.out.println("现在你在" + person.getCurrentRoom().toString());
        System.out.print("出口有：");
        System.out.println(person.getCurrentRoom().getExitDescrip());
        if (person.getCurrentRoom().isWithLiving()) {
            System.out.print("这里有只");
            System.out.println(monster.toString());
            System.out.print("ID：" + monster.getId() + "\t\t生命值：" + monster.getHP() + "\t\t攻击力：" + monster.getATK() + "\t\t防御力：" + monster.getDEF());
        } else {
            System.out.print("这里似乎很安静。");
        }
        System.out.println();
    }

    //展示决斗场景
    public void showDuel() {
        Person person = Person.getPerson();
        Monster monster = person.getCurrentRoom().getMonster();

        while (person.getHP() > 0 && monster.getHP() > 0) {
            person.attack(monster);
            System.out.println("---------------------------------------------------------------");
            System.out.print("你发起进攻，对" + monster.getName() + "造成了" + (person.getATK() - monster.getDEF()) + "点伤害");
            System.out.println("，当前生命值" + monster.getHP());
            if (monster.getHP() <= 0) {
                break;
            }
            proStop(1000);
            monster.attack(person);
            System.out.print(monster.getName() + "发起进攻，对" + person.getName() + "造成了" + (monster.getATK() - person.getDEF()) + "点伤害");
            System.out.println("，当前生命值" + person.getHP());
            proStop(1000);
        }
        System.out.println("-----------------------------------------------------------------");
        if (person.getHP() > 0) {
            System.out.println("你成功击败了" + monster.getName() + "!");
            person.getProps(monster.getProps().getName(), monster.getProps());
            person.upLevel(monster.getDNA());
            person.getCurrentRoom().setWithLiving(false);
        } else {
            System.out.println("你死亡了");
            System.out.println("游戏结束!");
            System.exit(0);
        }
    }

    //程序暂停
    public void proStop(long time) {
        try {
            sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if (words.length > 1)
                value = words[1];
            if (handler != null){
                handler.doCmd(value);
                if (handler.isBye())
                    break;
            } else {
                System.out.println("请输入正确指令！");
            }
        }

        in.close();
    }
}
