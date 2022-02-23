package proxy;

import java.lang.reflect.Proxy;

public class TestMain {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        SubjectHandler handler = new SubjectHandler(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        subject.printName("test");
    }
}
