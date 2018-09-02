package game;

import java.util.Scanner;

public class mygame {
    private int[] gezi=new int[7];
    int hitted_count=0;

    public void setGezi(int x,int y){
        gezi[x]=y;
        }

    public int getgezi(int x){
        return gezi[x];
    }

    int getRandom(){
        return (int)(Math.random()*7);
    }

    void test(int x){
        if (getgezi(x)==1){
            System.out.println("ship_part: "+x+" "+"被击中！");
            setGezi(x,0);
            hitted_count+=1;
        }
        else{
            System.out.println("missed");
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
        for (int x=0;x<7;x+=1){
           gamestart.setGezi(x,0);
        }

        int randomshippart=gamestart.getRandom();
        if (randomshippart==0){
            gamestart.setGezi(randomshippart, 1);
            gamestart.setGezi(randomshippart+1, 1);
            gamestart.setGezi(randomshippart+2, 1);
        }
        if (randomshippart==6){
            gamestart.setGezi(randomshippart, 1);
            gamestart.setGezi(randomshippart-1, 1);
            gamestart.setGezi(randomshippart-2, 1);
        }
        else {
            gamestart.setGezi(randomshippart, 1);
            gamestart.setGezi(randomshippart - 1, 1);
            gamestart.setGezi(randomshippart + 1, 1);
        }

        player pl=new player();
        int lauch_counter=6;

        while (true) {
            if ((lauch_counter > 0) & (gamestart.hitted_count < 3)) {
                System.out.println("请输入你发射的鱼雷（注意！你的鱼雷库存只剩6个了！！）想要对准的part:  ");
                lauch_counter -= 1;
                int plguessshippart = pl.plinput.nextInt();
                int plguessing = pl.plguess(plguessshippart);
                gamestart.test(plguessing);
            }
            else if (gamestart.hitted_count == 3) {
                System.out.println("恭喜！ship已被击沉，impossible mission completed!");
                System.out.println("你总共浪费了：  " + (lauch_counter - 3) + "   个鱼雷！");
                break;
            }
            else{
                System.out.println("鱼雷用尽，possible mission faild!");
                break;
            }
        }

    }
}
