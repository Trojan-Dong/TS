package time;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeConvertTest {
    
    public static void main(String[] args) {
        LocalDate localDate = LocalDateTime.now().toLocalDate();
        System.out.println(localDate);
        
        int num = 1;
        while (true) {
            if (num % 10 == 0) {
                System.out.println(num);
                return;
            } else {
                num++;
            }
        }
    }
}
