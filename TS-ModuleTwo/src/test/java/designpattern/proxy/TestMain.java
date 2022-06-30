package designpattern.proxy;

import designpattern.proxy.cglibProxy.SubjectMethodInterceptor;
import designpattern.proxy.jdkProxy.SubjectHandler;
import designpattern.proxy.jdkProxy.SubjectJDKProxyFactory;
import designpattern.proxy.cglibProxy.CglibProxyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Subject realSubject = new RealSubject();

        Class clazz = Class.forName("designpattern.proxy.RealSubject");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method method = clazz.getMethod("printName", String.class);
        method.invoke(clazz.newInstance(), "test");
//        Subject.class.getClassLoader();
        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();
        SubjectHandler handler = new SubjectHandler(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);
        subject.printName("test");

        //JDKProxy
        Subject subjectOne = (Subject) SubjectJDKProxyFactory.getProxy(new RealSubject());
        subjectOne.printName("test");
        //CglibProxy
        RealSubject realSubject1 = (RealSubject) CglibProxyFactory.getProxy(RealSubject.class,new SubjectMethodInterceptor());
        realSubject1.printName("java");


    }
}
