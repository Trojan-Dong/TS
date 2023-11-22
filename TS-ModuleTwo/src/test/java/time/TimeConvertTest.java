package time;

import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeConvertTest {

    public static void main(String[] args) {
//        System.out.println(LocalDateTimeUtil.parseDate("2023-11-17","MM/dd/yyyy"));
        System.out.println(LocalDateTimeUtil.parseDate("11/17/2023", "MM/dd/yyyy"));
//        LocalDate localDate = LocalDateTime.now().toLocalDate();
//        System.out.println(localDate);
//
//        int num = 1;
//        while (true) {
//            if (num % 10 == 0) {
//                System.out.println(num);
//                return;
//            } else {
//                num++;
//            }
//        }
    }
}
