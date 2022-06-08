package proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Subject realSubject = new RealSubject();
//        Class clazz = Class.forName("proxy.RealSubject");
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//        Method method = clazz.getMethod("printName", String.class);
//        method.invoke(clazz.newInstance(), "test");
//        ClassLoader loader = realSubject.getClass().getClassLoader();
//        Class[] interfaces = realSubject.getClass().getInterfaces();
//        SubjectHandler handler = new SubjectHandler(realSubject);
//        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
//        subject.printName("test");

//        Subject subjectOne = (Subject) SubjectJDKProxyFactory.getProxy(new RealSubject());
//        subjectOne.printName("test");
        RealSubject realSubject1 = (RealSubject) CglibProxyFactory.getProxy(RealSubject.class,new SubjectMethodInterceptor());
        realSubject1.printName("java");


    }
}
