package test;
//todo:3行4列的棋盘,a,b,c;1,2,3,4

import java.util.Arrays;

import static java.lang.System.out;

class Test {
    public static void main(String[] args) {
        Test t = new Test();
        for (String[] each : t.Pan()) {
            out.println(Arrays.toString(each));
        }
    }

    public String[][] Pan() {
        String qipan[][] = new String[5][5];
        String[] hang = {"A", "B", "C", "D", "E"};
        String[] lie = {"1", "2", "3", "4", "5"};

        for (int i = 0; i < qipan.length; i++) {
            for (int j = 0; j < qipan[0].length; j++) {
                qipan[i][j] = new String(hang[i] + lie[j]);
            }
        }
        return qipan;
    }
}
