package system;

import java.math.BigDecimal;
import java.util.Optional;

public class OptionalTest {
    
    public static void main(String[] args) {
        String str = "";
        System.out.println(Optional.ofNullable(str).map(s -> new BigDecimal(s)).orElse(BigDecimal.ONE));
    }
}
