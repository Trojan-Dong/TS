package test;

import java.math.BigDecimal;

public class BigDecimalTest {
    
    public void methodA() {
    
    }
    
    public void methodB() {
    }
    
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(20);
        BigDecimal c = BigDecimal.ONE;
        //        System.out.println(a.subtract(b));
        //        System.out.println(a);
        Test test = new Test();
        TestB testB = new TestB();
        testB.setA(a);
        test.setA(testB.getA());
        testB.setA(b);
        System.out.println(test.getA());
        System.out.println(testB.getA());
    }
}
