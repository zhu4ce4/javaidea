//todo:待升级为2维;尽量使用变量+方法的方式：用方法改变变量，用变量推动游戏进程。

package game;

import java.util.ArrayList;
import java.util.Scanner;

class 引擎 {

    int 船舱数 = 10;
    int 随机油箱 = (int) (Math.random() * 船舱数);
    int 被击中数 = 0;
    int 油箱数 = 3;
    private ArrayList<Integer> 油箱 = new ArrayList<>();

    public void 初始化敌船() {
        for (int x = 0; x < 油箱数; x++) {
            油箱.add(随机油箱);
        }
        }

    public String 检查油箱(int x) {
        if ((x < 0) || (x > 船舱数)) {
            System.out.println("鱼雷偏离敌船,更别提油箱了，请调整你的射击角度！");
            return "missed";
        } else if (!油箱.contains(x)) {
            System.out.println("hitted the boat but the 油箱！come on!");
            return "missed";
        } else if (油箱.contains(x)) {
            被击中数++;
            油箱.remove(x);
            if (!油箱.isEmpty()) {
                System.out.println(String.format("敌船油箱: " + x + " " + "被击中！\n还剩%d个油箱未摧毁！", (油箱数 - 被击中数)));
                return "hitted";
            }

        }

        if (get船体(x) == 1) {
            被击中数 += 1;
            set船体(x, 0);
        } else{
            if (x > 随机开始点) {
                System.out.println("missed\n似乎偏右了一点");
            } else {
                System.out.println("missed\n似乎偏左了一点");
            }

        }
    }
}


class player{
    int 鱼雷 = 18;       //todo:改为18,也即3条命，每发射到6个减去一条命

    int fire() {
        Scanner plinput = new Scanner(System.in);
        int target = plinput.nextInt();
        return target;
    }
}


class 开始游戏 {
    public static void main(String[] args){
        引擎 新游戏 = new 引擎();
        新游戏.初始化敌船();

        player pl=new player();
        int yulei_left = pl.鱼雷;

        while (yulei_left > 0) {
            int target = pl.fire();
            yulei_left--;
            新游戏.检查油箱(target);
            if (yulei_left < 1) {


            }

            if (新游戏.被击中数 < 3) {
                System.out.println(String.format("*******\n请发射鱼雷（注意！你的鱼雷库存只剩%d颗了！！）对准敌船的油箱[疑似为0到10]:  \n*******", pl.鱼雷));
                鱼雷--;
                int plguessshippart = pl.plinput.nextInt();
                int plguessing = pl.plguess(plguessshippart);
                新游戏.test(plguessing);
            } else if (新游戏.被击中数 == 3) {
                System.out.println("*******\n恭喜！敌船已被击沉!\nimpossible mission completed!\n今晚吃鸡！");
                System.out.println("但你总共浪费了：  " + (3 - lauch_counter) + "   颗鱼雷！\n*******");
                break;
            }
        }
        System.out.println("*******\n鱼雷用尽，possible mission failed!\n你被将军executed.\n*******");
    }
}
