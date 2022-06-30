package thread;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("1"); // ThreadLocalMap.put(key,value) key=Thread.threadLocalHashCode
        threadLocal.remove();
        System.out.println(threadLocal.get());
    }
}
