//todo:待升级为2维;尽量使用变量+方法的方式：用方法改变变量，用变量推动游戏进程。

package game;

import java.util.Scanner;

public class mygame {
    int start = (int) (Math.random() * 100);
    int hitted_count=0;
    private int[] 船体;

    public void init船体(int[] init) {
        船体 = init;
    }

    public void set船体(int x, int y) {
        if ((x < 0) || (x > 100)) {
            System.out.println("无此目标");
        } else {
            船体[x] = y;
        }
    }

    public int get船体(int x) {
        if ((x < 0) || (x > 100)) {
            System.out.println("鱼雷偏离敌船,更别提弹药库了，请调整你的射击角度！");
            return 999999999;
        } else {
            return 船体[x];
        }
    }

    void test(int x){
        if (get船体(x) == 1) {
            hitted_count+=1;
            System.out.println(String.format("敌船弹药库: " + x + " " + "被击中！\n还剩%d个弹药库未摧毁！", (3 - hitted_count)));
            set船体(x, 0);
        } else{
            if (x > start) {
                System.out.println("missed\n似乎偏右了一点");
            } else {
                System.out.println("missed\n似乎偏左了一点");
            }

        }
    }
}


class player{
    Scanner plinput=new Scanner(System.in);

    int plguess(int x){
        return x;
    }
}


class mygametestdriver{
    public static void main(String[] args){
        mygame gamestart=new mygame();

//        gamestart.init船体(gamestart.start);

        player pl=new player();
        int lauch_counter=6;

        while (lauch_counter > 0) {
            if (gamestart.hitted_count < 3) {
                System.out.println(String.format("*******\n请发射鱼雷（注意！你的鱼雷库存只剩%d颗了！！）对准敌船的疑似弹药库[0到100]:  \n*******", lauch_counter));
                lauch_counter--;
                int plguessshippart = pl.plinput.nextInt();
                int plguessing = pl.plguess(plguessshippart);
                gamestart.test(plguessing);
            } else if (gamestart.hitted_count == 3) {
                System.out.println("*******\n恭喜！敌船已被击沉!\nimpossible mission completed!\n今晚吃鸡！");
                System.out.println("但你总共浪费了：  " + (3 - lauch_counter) + "   颗鱼雷！\n*******");
                break;
            }
        }
        System.out.println("*******\n鱼雷用尽，possible mission failed!\n你被将军executed.\n*******");
    }
}
