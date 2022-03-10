package thread;

import java.util.concurrent.*;

public class TestThread {

    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                10, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<Runnable>());
        Thread one = new Thread(new ThreadOne(), "one");
        Thread two = new Thread(new ThreadOne(), "two");
        Thread three = new Thread(new ThreadOne(), "three");
        one.start();
        two.start();
        three.start();

    }
}
