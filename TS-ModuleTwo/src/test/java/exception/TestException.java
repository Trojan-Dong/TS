package exception;

import org.junit.jupiter.api.Test;

public class TestException {
    public void aTest() {
        int a = 1 / 0;
    }

    public static void main(String[] args) {
        new TestException().aTest();
    }
}
