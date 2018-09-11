//todo:1、待升级为2维，2、若未击中加入偏左或偏右的提示；3、每次复活重置油箱位置，但保留剩余的鱼雷数量，不得重置;尽量使用面向对象：变量+方法的方式：用方法改变变量，用变量推动游戏进程。

package game;
import java.util.ArrayList;
import java.util.Scanner;

class 游戏引擎 {
    int 船舱数 = 10;
    int 随机油箱1 = (int) (Math.random() * 船舱数);   //todo:存在可能会重复数的bug
    int 随机油箱2 = (int) (Math.random() * 船舱数);
    int 随机油箱3 = (int) (Math.random() * 船舱数);

    int[] items = new int[2];
    int 被击中数 = 0;
    int 油箱数 = 3;
    private ArrayList<Integer> 油箱 = new ArrayList<Integer>();

    public void 初始化敌船(int p) {
        油箱.add(p);
    }

    private int[] 检查油箱(int x) {
        int y = 油箱.indexOf(x);        //在此做了一个转换，否则会出错！
        if ((x < 0) || (x > 船舱数)) {
            System.out.println("鱼雷偏离敌船,更别提油箱了，请调整你的射击角度！");
        } else if (!油箱.contains(x)) {
            System.out.println("hitted the boat but the 油箱！come on!");
        } else if (油箱.contains(x)) {
            被击中数++;
            油箱数--;
            油箱.remove(y);   //利用上面的转换，否则会出错！
            System.out.println(String.format("敌船油箱: " + x + " " + "被击中！还剩%d个油箱未摧毁！come on!", (油箱数)));
            }

        items[0] = 被击中数;
        items[1] = 油箱数;
        return items;
    }

    public void endgame() {
        player pl = new player();
        int yulei_left = pl.鱼雷;
        System.out.println(String.format("遗憾的是：我们的鱼雷库存仅剩余%d颗了！且用且珍惜吧！", yulei_left));
        while (yulei_left > 0) {
            System.out.println(String.format("*******\n请发射鱼雷（注意！你的鱼雷库存只剩%d颗了！！）对准敌船的船舱[0-10]:  \n*******", yulei_left));
            int target = pl.fire();
            yulei_left--;
            int[] itemss = 检查油箱(target);
            int youxiang_left = itemss[1];
//            int hitted_count = items[1];
            if ((yulei_left == 12) && (youxiang_left) > 0) {
                System.out.println("无能的你被愤怒的将军executed，但皇帝将你复活，让你重振旗鼓");
            } else if ((yulei_left == 6) && (youxiang_left) > 0) {
                System.out.println("懦弱胆小的你被愤怒的皇帝executed，但God将你复活，让你戴罪立功");
            } else if ((yulei_left == 0) && (youxiang_left) > 0) {
                System.out.println("鱼雷用尽的你被愤怒的 GOD executed，possible mission failed!\nshame!shame!shame!\n******是非成败转头空，多少英雄事都付笑谈中！******");
                break;
            } else if ((youxiang_left == 0) && (yulei_left < 15)) {
                System.out.println(String.format("敌船击沉！但是你总共浪费了%d颗鱼雷\n******无功无过，平平无奇。******", (18 - 3 - yulei_left)));
                break;
            } else if ((youxiang_left == 0) && (yulei_left == 15)) {
                System.out.println("敌船被击沉！且一点没浪费！\n******Impossible mission completed!今晚吃鸡！******");
                break;
            }
        }
    }
}


class player{
    int 鱼雷 = 18;    //每用6颗鱼雷死一条命；共3条命
    int fire() {
        Scanner plinput = new Scanner(System.in);
        int target = plinput.nextInt();
        return target;
    }
}


class 开始游戏 {
    public static void main(String[] args) {
        游戏引擎 新游戏 = new 游戏引擎();

        新游戏.初始化敌船(新游戏.随机油箱1);   //todo:待修改简化
        新游戏.初始化敌船(新游戏.随机油箱2);
        新游戏.初始化敌船(新游戏.随机油箱3);

        System.out.println("接上峰命令:对敌船进行全力攻击！情报显示：敌船3个油箱位于船舱的0到10舱位间，需将3个油箱全击中才能击沉敌船,上帝保佑你!");
        新游戏.endgame();
    }
}
