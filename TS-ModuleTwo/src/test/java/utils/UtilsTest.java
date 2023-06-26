package utils;

import java.math.BigDecimal;

public class UtilsTest {
    
    public static void main(String[] args) {
        System.out.println(MathUtils.add(new BigDecimal(10), new BigDecimal(20), new BigDecimal(10)));
        System.out.println(MathUtils.subtract(new BigDecimal(10), new BigDecimal(20), new BigDecimal(10)));
        System.out.println(MathUtils.multiply(new BigDecimal(10), new BigDecimal(20), new BigDecimal(10)));
        System.out.println(MathUtils.divide(new BigDecimal(10), new BigDecimal(0), new BigDecimal(10)));
        System.out.println(MathUtils.divide(new BigDecimal(10), new BigDecimal(0), new BigDecimal(10)));
    }
}
