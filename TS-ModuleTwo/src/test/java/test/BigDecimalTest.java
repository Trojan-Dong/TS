package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    
    public void methodA() {
    
    }
    
    public void methodB() {
    }
    
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(20.455000);
        BigDecimal c = BigDecimal.ONE;
        //        System.out.println(a.subtract(b));
        //        System.out.println(a);
      
        System.out.println(b.setScale(2, RoundingMode.CEILING));
        System.out.println(b.setScale(2, RoundingMode.DOWN));
        System.out.println(b.setScale(2, RoundingMode.FLOOR));
        System.out.println(b.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println(b.setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(b.setScale(2, RoundingMode.HALF_UP));
    
    }
}
