package test;

import static java.lang.System.out;

public class Mamm {

    public static void main(String[] args) {
        String[][] cheng = new String[9][];
        for (int n = 0; n < 9; n++) {
            cheng[n] = new String[n + 1];
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                cheng[i - 1][j - 1] = String.format("%d * %d = %d", i, j, i * j);
            }
        }
        for (String[] each : cheng) {
            for (String eachone : each) {
                out.printf("%16s", eachone);
            }
            out.println();
        }

    }
}
