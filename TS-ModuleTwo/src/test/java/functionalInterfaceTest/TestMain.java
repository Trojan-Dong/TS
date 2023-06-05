package functionalInterfaceTest;

public class TestMain {

    public void test(LambdaTest lambdaTest) {
        lambdaTest.lambdaT();
    }

    public void testOne() {
        test(() -> System.out.println("test"));
    }
}
