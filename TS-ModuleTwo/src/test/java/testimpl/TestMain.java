package testimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class TestMain {
    
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.49");
        BigDecimal b = new BigDecimal("0.01");
        System.out.println(a.multiply(b).setScale(2, RoundingMode.HALF_UP));
        System.out.println(a.multiply(b).setScale(2, RoundingMode.HALF_UP).compareTo(BigDecimal.ZERO) == 0);
        
        //        CImpl service = new CImpl();
        //        service.test();
        //        System.out.println(LocalDateTime.now().compareTo(LocalDateTime.now().minusDays(1)));
        //        System.out.println(LocalDateTime.now().compareTo(LocalDateTime.now()));
        //        System.out.println(LocalDateTime.now().compareTo(LocalDateTime.now().plusDays(1)));
    }
}
