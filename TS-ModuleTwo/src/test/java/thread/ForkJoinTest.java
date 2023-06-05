package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest fork = new ForkJoinTest();
        fork.fork();
        fork.join();
        fork.compute();
        pool.execute(fork);
    }

    @Override
    protected Object compute() {
        return null;
    }
}
