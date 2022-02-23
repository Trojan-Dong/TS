package thread;

import java.util.concurrent.*;

public class TestThread {

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
    }
}
