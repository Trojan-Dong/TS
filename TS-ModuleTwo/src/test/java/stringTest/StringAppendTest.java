package stringTest;

import java.util.Collections;

public class StringAppendTest implements Comparable<StringAppendTest> {
    private int number;

    public static void main(String[] args) {
        //string的+拼接实际是调用了StringBuilder的append方法
        //每次新建一个StringBuilder 对象
        String a = "123";
        a += 123;
        a += "321";
        System.out.println(a);
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
    }

    @Override
    public int compareTo(StringAppendTest o) {
        if (this.number > o.number) {
            return 1;
        } else if (this.number < o.number) {
            return -1;
        }
        return 0;
    }
}
