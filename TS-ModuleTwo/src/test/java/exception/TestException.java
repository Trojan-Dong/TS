package exception;

public class TestException {
    public void aTest() {
        int a = 1 / 0;
    }

    public static void main(String[] args) {
        try {
            new TestException().aTest();
        } catch (Exception e) {
            e.printStackTrace();
//            System.exit(1);
        } finally {
            System.out.println("finally");
        }
    }
}
