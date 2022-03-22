package thread;

import java.util.concurrent.*;

public class TestThread {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
//        Thread one = new Thread(new ThreadOne(), "one");
//        Thread two = new Thread(new ThreadOne(), "two");
//        Thread three = new Thread(new ThreadOne(), "three");
//        one.start();
//        two.start();
//        three.start();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            Future future = executor.submit(new ThreadOne());
        }
//        Future future = executor.submit(new ThreadOne());

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
