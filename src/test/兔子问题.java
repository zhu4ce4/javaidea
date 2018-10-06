package test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
古典问题：最开始有一对新出生的兔子，已知兔子特点:每只兔子从出生后的第3个月起（包含当月）每个月都会生一对兔子，假如兔子都不死，问若如此繁衍，未来12个月内每个月的兔子总数为多少？
*/
class Tuzi {
    private static int totalNumOfTuzi = 0;
    private static int monthNow = 0;

    private int birthMonthOfTuzi;

    public Tuzi() {
        birthMonthOfTuzi = monthNow;
        totalNumOfTuzi++;
    }

    public static void main(String[] args) {
//        ArrayList<Tuzi> tuziwo=new ArrayList<>(); //todo:线程问题导致失败？？https://www.jianshu.com/p/c5b52927a61a
        List<Tuzi> tuziwo = new CopyOnWriteArrayList<>();
        Tuzi n1 = new Tuzi();
        Tuzi n2 = new Tuzi();
        tuziwo.add(n1);
        tuziwo.add(n2);

        int i = 12;
        do {
//            Iterator<Tuzi> iter = tuziwo.iterator();
            for (Tuzi each : tuziwo) {
//            while (iter.hasNext()){
//                Tuzi each=iter.next();
                for (Tuzi eachNewBirth : each.giveBirthOrNot()) {
                    if (eachNewBirth != null) {
                        tuziwo.add(eachNewBirth);
                    }
                }
            }
            System.out.printf("现在是第 %d 个月,现在的兔子总数是: %d\n", monthNow, totalNumOfTuzi);
            monthNow++;
            i--;
        } while (i > 0);
    }

    public Tuzi[] giveBirthOrNot() {
        Tuzi[] tuziwoTemp = new Tuzi[2];
        if (monthNow - birthMonthOfTuzi > 2) {
            tuziwoTemp[0] = new Tuzi();
            tuziwoTemp[1] = new Tuzi();
            return tuziwoTemp;
        } else {
            tuziwoTemp[0] = null;
            tuziwoTemp[1] = null;
            return tuziwoTemp;
        }
    }
}

