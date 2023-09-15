package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheckTest {
    
    public void strTest(String str){
        str="";
    }
    public static void main(String args[]) {
        RegexCheckTest test=new RegexCheckTest();
        String str = "20230831-ACH.CSV";
        test.strTest(str);
        System.out.println(str);
//        String pattern = "(?i)20230831-ACH.CSV";
//
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(str);
//        System.out.println(m.matches());
    }
    
}
