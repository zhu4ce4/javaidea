package test;

import java.util.Arrays;

import static java.lang.System.out;


public class MaoPaoPaixu {
    public static void main(String[] args) {
        String[] name = {"z", "c", "m", "b"};
        for (int i = 0; i < name.length; i++) {
            for (int j = i + 1; j < name.length; j++) {
                if ((name[i].compareTo(name[j])) > 0) {
                    String temp = name[j];
                    name[j] = name[i];
                    name[i] = temp;
                }
            }
        }
        out.println(Arrays.toString(name));
    }
}
