package thread;

import java.io.*;

public class ThreadOne implements Runnable {
//    private static final ThreadLocal<TA> ta = ThreadLocal.withInitial(() -> new TA());

    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName() + ":" + i);
//        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
