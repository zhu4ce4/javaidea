package test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

//todo:输入一个日期，判断是否合法，2018-08-08；20180808；2018/08/08；其他不合法；注意闰年2--29，135781012--31，其他不合法；2种方法：1、调用构造器先构造日期；2、输入一个string后解析为日期；
public class RiQiTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = new String[3];
        out.println("请输入您的出生年份:");
        input[0] = in.next();
        out.println("请输入您的出生月份:");
        input[1] = in.next();
        out.println("请输入您的出生日子:");
        input[2] = in.next();
        RiQi rq = new RiQi(input);
        rq.riqiTestPrint();
    }
}

class RiQi {
    private String year;
    private String month;
    private String day;

    public RiQi(String[] riqi_string) {
        year = riqi_string[0];
        month = riqi_string[1];
        day = riqi_string[2];
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getBirthday() {
        return year + month + day;
    }

    public void yearTest(String syear) {
        Pattern p = Pattern.compile("^\\d{4}$");
        Matcher m = p.matcher(syear);
        LocalDate now = LocalDate.now();

        if (!m.find()) {
            errPrintExit("年份");
        } else if (Integer.parseInt(m.group()) > now.getYear()) {
            errPrintExit("年份");
        }
        year = m.group();
    }

    public void monthTest(String smonth) {
        Pattern p = Pattern.compile("^\\d{1,2}$");
        Matcher m = p.matcher(smonth);
        if (!m.find()) {
            errPrintExit("月份");
        } else if (Integer.parseInt(m.group()) > 12 || Integer.parseInt(m.group()) < 1) {
            errPrintExit("月份");
        }
        if (m.group().length() == 1) {
            month = "0" + m.group();
        } else {
            month = m.group();
        }
    }

    public void dayTest(String sday) {
        Pattern p = Pattern.compile("^\\d{1,2}$");
        Matcher m = p.matcher(sday);

        String[] s = {"02", "04", "06", "09", "11"};

        if (!m.find()) {
            errPrintExit("日子");
        } else if (this.month.equals("02") && chickDay(Integer.parseInt(this.year)) && Integer.parseInt(sday) > 29) {
            errPrintExit("日子");
        } else if (this.month.equals("02") && !chickDay(Integer.parseInt(this.year)) && Integer.parseInt(sday) > 28) {
            errPrintExit("日子");
        } else if (Arrays.asList(s).contains(this.month) && Integer.parseInt(sday) > 30) {
            errPrintExit("日子");
        } else if (Integer.parseInt(sday) > 31) {
            errPrintExit("日子");
        }
        if (m.group().length() == 1) {
            day = "0" + sday;
        } else {
            day = sday;
        }
    }

    public boolean chickDay(int iPara) {
        return (iPara % 100 != 0 && iPara % 4 == 0) || iPara % 400 == 0;
    }

    public void riqiTestPrint(RiQi this) {
        this.yearTest(this.getYear());
        this.monthTest(this.getMonth());
        this.dayTest(this.getDay());
        out.println(this.getBirthday());
    }

    public void errPrintExit(String errTh) {
        out.printf("%s输入有误!\n", errTh);
        System.exit(999);
    }
}
