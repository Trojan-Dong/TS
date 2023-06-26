package enumt;

/**
 * @Author DGJ
 * @Date 2023/6/20
 * @Description 枚举类测试
 * @Version 1.0
 **/
public class EnumTest {
    
    public void test() {
    }
    
    public static void main(String[] args) {
        
        System.out.println(BalSumWayEnum.valueOf("LOCK") == BalSumWayEnum.valueOf("LOCK"));
        System.out.println(BalSumWayEnum.LOCK.name());
        System.out.println(BalSumWayEnum.valueOf("lock"));//异常 严格遵循大小写
        System.out.println(BalSumWayEnum.LOCK); //返回结果为枚举类型 打印结果为String类型 重写了toString方法
        System.out.println(System.currentTimeMillis());
    }
}
