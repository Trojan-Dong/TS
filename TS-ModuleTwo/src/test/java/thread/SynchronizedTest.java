package thread;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
    public synchronized void method() {
        System.out.println("synchronized 代码块");
        ReentrantLock reentrantLock = new ReentrantLock();
    }

    public static void main(String[] args) {

    }
}
