package testimpl;

import java.time.LocalDateTime;

public class TestMain {
    
    public static void main(String[] args) {
//        CImpl service = new CImpl();
//        service.test();
    
        System.out.println(LocalDateTime.now().compareTo(LocalDateTime.now().minusDays(1)));
        System.out.println(LocalDateTime.now().compareTo(LocalDateTime.now()));
        System.out.println(LocalDateTime.now().compareTo(LocalDateTime.now().plusDays(1)));
    }
}
