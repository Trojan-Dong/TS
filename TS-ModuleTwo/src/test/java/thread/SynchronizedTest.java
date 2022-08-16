package thread;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
//    public synchronized static void method() {
//        System.out.println("synchronized 代码块");
//    }

//    public static void main(String[] args) {
//        System.out.println("synchronized 代码块");
//    }

    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
