package thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class LockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.readLock();
        StampedLock stampedLock = new StampedLock();
        stampedLock.readLock();
    }
}
