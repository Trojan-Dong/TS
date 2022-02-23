package designpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestC {
    public static String sta = "11222255";
    public static String stb = "334466";

    public static void init(List a, List b) {
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(2);
        a.add(2);
        b.add(3);
        b.add(3);
        b.add(4);
        b.add(4);
        a.add(5);
        a.add(5);
        b.add(6);
        b.add(6);
    }

    public static boolean compare(String a, String b) {
        if (Integer.valueOf(a) == 66) {
            return false;
        } else {
            if (a.length() == b.length()) {
                if (Integer.valueOf(a) < Integer.valueOf(b)) {
                    return true;
                } else {
                    return false;
                }
            } else if (b.length() == 4) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean ruler(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(0) != (str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String gv(String str) {
        boolean flag = true;
        if (str.equals(sta)) {
            flag = true;
        }
        Random random = new Random();
        int bIndex = 0;
        int endIndex = str.length() - 1;
        while (true) {
            bIndex = random.nextInt(str.length());
            endIndex = random.nextInt(str.length() - bIndex) + 1 + bIndex;
            String res = str.substring(bIndex, endIndex);
            if (ruler(res)) {
//                System.out.println(String.format("bIndex:%d,eIndex:%d,res:%s", bIndex, endIndex, res));
                if (flag) {
                    sta = str.replaceFirst(res, "");
                } else {
                    stb = str.replaceFirst(res, "");
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        String  stra = gv(stb);;
        String strb;
        if (System.currentTimeMillis() % 2 == 0) {
            while (true) {
                if (compare(stra, strb = gv(stb))) {
                    System.out.println(stra + "" + strb);
                    break;
                }
            }
        }

    }
}
