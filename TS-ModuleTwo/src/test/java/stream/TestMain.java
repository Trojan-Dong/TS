package stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {
    
    public static List<BigDecimal> test() {
        List<BigDecimal> list = new ArrayList<>();
        List<BigDecimal> resultList = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            list.add(BigDecimal.valueOf(i));
        }
        // foreach中的return 不会跳出方法
        list.forEach(x -> {
            if (x.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO) != 0) {
                return;
            }
            resultList.add(x);
        });
        return resultList;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.asList("EC_TRANSFER,POS_TRANSFER,PRE_TRANSFER,ATM_WITHDRAWAL            ".split(","))
                .contains("POS_TRANSFER"));
        ;
        //        System.out.println(test().stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        //        System.out.println(test().stream().reduce(BigDecimal.ZERO, BigDecimal::subtract));
        //        System.out.println(test().stream().reduce(BigDecimal.ONE, BigDecimal::multiply));
        ////        System.out.println(test().stream().reduce(BigDecimal.ZERO, BigDecimal::divide));
        //        //        test().forEach(System.out::println);
        //        System.out.println(StringUtils.substring("123456", 2, 5));
        //
        //        testBool(null);
        LocalDate startDate = LocalDate.parse("20230930", DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (int i = 1; i<=90; i++) {
            System.out.println(startDate.plusDays(i).format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }
        
    }
    
    public static void testBool(Boolean flag) {
        if (flag) {
            System.out.println(true);
        }
    }
}
