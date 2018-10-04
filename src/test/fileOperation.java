package test;

import java.io.File;
import java.util.Date;

import static java.lang.System.out;

public class fileOperation {
    public static void main(String[] args) {
        try {
            fileOperation fo = new fileOperation();
            if (args.length == 0) {
                return;
            } else {
                String cmd = args[0];
                if (cmd.equals("del")) {
                    boolean bdel = fo.delFile(args[1]);
                    out.println("删除成功了?---" + bdel);
                } else if (cmd.equals("info")) {
                    String[] sTemp = fo.getFileInfo(args[1]);
                    for (String each : sTemp) {
                        out.println(each);
                    }
                } else {
                    out.println("选择有误!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public boolean delFile(String fileName) {
        try {
            boolean success = (new File(fileName)).delete();
            if (!success) {
                out.println("delete file failed");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String[] getFileInfo(String Name) {
        try {
            File file = new File(Name);
            long modifiedTime = file.lastModified();
            Date d = new Date(modifiedTime);
            long fileSize = file.length();
            boolean cr = file.canRead();
            boolean cw = file.canWrite();
            boolean in = file.isHidden();

            String[] sTemp = new String[8];
            sTemp[0] = String.valueOf(fileSize);
//            sTemp[1]=new Date(modifiedTime).toString();
            sTemp[1] = String.format("%1$tF %1$tT", d);
            sTemp[2] = String.valueOf(cr);
            sTemp[3] = String.valueOf(cw);
            sTemp[4] = String.valueOf(in);
            sTemp[6] = String.valueOf(file.getPath());
            sTemp[5] = String.valueOf(file.getCanonicalPath());
            sTemp[7] = String.valueOf(file.getAbsolutePath());
            return sTemp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
