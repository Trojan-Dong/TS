package proxy;

import proxy.cglibProxy.CglibProxyFactory;
import proxy.cglibProxy.SubjectMethodInterceptor;
import proxy.jdkProxy.SubjectJDKProxyFactory;

import java.lang.reflect.InvocationTargetException;

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

        //JDKProxy
        Subject subjectOne = (Subject) SubjectJDKProxyFactory.getProxy(new RealSubject());
        subjectOne.printName("test");
        //CglibProxy
        RealSubject realSubject1 = (RealSubject) CglibProxyFactory.getProxy(RealSubject.class,new SubjectMethodInterceptor());
        realSubject1.printName("java");


    }
}
