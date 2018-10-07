package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
*/
class ZhiYinData {
    private static int countZYData = 0;
    Integer[] arr = {2, 3, 5, 7};
    private int num;

    public ZhiYinData(int anum) {
        num = anum;
    }

    public static int getCountZYData() {
        return countZYData;
    }

    public ArrayList isZhiyinDataOrNot() {
//        Integer[] arr = {2, 3, 5, 7};
        List<Integer> list = Arrays.asList(arr);
        int[] result = qiuYu(num);
        ArrayList<Integer> zzs = new ArrayList<>();

        while (true) {              //逻辑理顺再写代码!!!
            if (result[0] == -1) {
                zzs.add(result[1]);
                return zzs;
            } else if (!list.contains(result[1])) {
                zzs.add(result[0]);
                result = qiuYu(result[1]);
                continue;
            } else {
                zzs.add(result[0]);
                zzs.add(result[1]);
                return zzs;
            }
        }
    }

    public int[] qiuYu(int anum) {
        int[] result = new int[2];
//        int[] s = {2, 3, 5, 7};
        int yuShu;

        for (int each : arr) {
            yuShu = anum % each;
            if (yuShu == 0) {
                result[0] = each;
                result[1] = anum / each;      //逻辑理顺再写代码!!!
                return result;
            }
        }
        result[0] = -1;
        result[1] = anum;
        return result;
    }

    public void printCountResult(ArrayList al) {
        if (al.size() < 2) {
            System.err.println(num + "不是质因数");
            return;
        }
        String i = "=";
        for (int j = 0; j < al.size() - 1; j++) {
            i += al.get(j) + "*";
        }
        i += al.get(al.size() - 1);
        countZYData++;
        System.out.println(num + i);
    }
}


class ZhiYinDataTest {
    public static void main(String[] args) {
        for (int j = 110; j < 122; j++) {
            ZhiYinData x = new ZhiYinData(j);
            x.printCountResult(x.isZhiyinDataOrNot());
        }
        System.out.printf("总共有%d个质因数", ZhiYinData.getCountZYData());
    }
}
