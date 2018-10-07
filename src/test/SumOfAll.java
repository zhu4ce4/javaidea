package test;

import java.util.Scanner;

/*
题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，
*/
public class SumOfAll {
    private int baseNum;
    private int times;

    public SumOfAll(int baseNum, int times) {
        this.baseNum = baseNum;
        this.times = times;
    }

    public void produceAddNum() {       //可用string拼接方法；
        int countAll = baseNum;
        int everyNum = baseNum;

        for (int i = 1; i < times; i++) {       //逻辑理清楚再写代码！
            everyNum += baseNum * ((int) Math.pow(10, i));
            countAll += everyNum;
        }
        System.out.printf("从%d一直加到%d个%d的和是%d \n", baseNum, times, baseNum, countAll);
    }
}

class SumOfAllTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入basenumber");
        int base = Integer.parseInt(in.next());
        System.out.println("请输入times");
        int times = Integer.parseInt(in.next());

//        SumOfAll soa = new SumOfAll(11, 3);   //另写code用string拼接转成int；
        SumOfAll soa = new SumOfAll(base, times);
        soa.produceAddNum();
    }
}

