package test;

/*
题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCount {
    private int letterCount;
    private int spaceCount;
    private int numCount;

    private String str;
    private int strLength;

    public StringCount(String s) {
        if (s != null && !"".equals(s)) {
            str = s;
            strLength = str.length();
        } else {
            System.err.println("String输入有误！");
        }
    }

    public int getLetterCount() {
        return letterCount;
    }

    public int getSpaceCount() {
        return spaceCount;
    }

    public int getNumCount() {
        return numCount;
    }

    public int getStrLength() {
        return strLength;
    }

    public void counts() {
        Pattern letter = Pattern.compile("[\\u4e00-\\u9fa5a-zA-Z]{1}");
        Pattern space = Pattern.compile("\\s{1}");
        Pattern num = Pattern.compile("\\d{1}");

        Matcher ml = letter.matcher(str);
        Matcher ms = space.matcher(str);
        Matcher mn = num.matcher(str);

        while (ml.find()) {
            str = removeCharAt(str, str.indexOf(ml.group()));
            letterCount++;
        }
        while (ms.find()) {
            str = removeCharAt(str, str.indexOf(ms.group()));
            spaceCount++;
        }
        while (mn.find()) {
            str = removeCharAt(str, str.indexOf(mn.group()));
            numCount++;
        }
    }

    public String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}


class StringCountTest {
    public static void main(String[] args) {
//        StringCount sc=new StringCount(null);
//        StringCount sc = new StringCount("qb\\q  3中\3 4%\d$&*(0)-=");     //注意转义字符\可能带来的bug
        StringCount sc = new StringCount("qbq  3中\3 4%\\d$&*(0)-=");     //注意转义字符\可能带来的bug
        sc.counts();
        System.out.printf("共有个%d中英文字符,共有%d个空格,共有%d个数字,共有%d个其他", sc.getLetterCount(), sc.getSpaceCount(), sc.getNumCount(), (sc.getStrLength() - sc.getLetterCount() - sc.getSpaceCount() - sc.getNumCount()));
    }
}
