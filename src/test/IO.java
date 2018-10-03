package test;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.err;
import static java.lang.System.out;

class StandardIO {
    public static void main(String[] args) {
//        ArrayList<String> strlist = new ArrayList<>();
        Vector vtemp = new Vector();
        boolean nowQuit = false;
        Pattern re1 = Pattern.compile("^(\\w{2}):(.+)");

        while (!nowQuit) {
            out.println("请输入>>");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            Matcher m1 = re1.matcher(input);
            if (m1.find() && m1.group(1).equalsIgnoreCase("in")) {
//                strlist.add(m1.group(1).trim());
                vtemp.addElement(m1.group(2).trim());
            } else if (input.trim().equalsIgnoreCase("out")) {
//                for (String each:strlist){
//                    out.println(each);
//                }
                for (int i = 0; i < vtemp.size(); i++) {
                    out.println(i + ": " + vtemp.elementAt(i));
                }
            } else if (input.trim().equalsIgnoreCase("quit")) {
                nowQuit = true;
            } else {
                err.println("输入有误！\n格式应为\n in:command 或者\n out 或者\n quit");
            }
        }
    }
}
