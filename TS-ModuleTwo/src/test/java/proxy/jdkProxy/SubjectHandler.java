package proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JDK动态代理类  只能代理实现了接口的类
 */
public class SubjectHandler implements InvocationHandler {
    private Object obj;

    public SubjectHandler(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        System.out.println(method);
        Object returnValue = method.invoke(obj, args);
        System.out.println("after");
        return returnValue;
    }
}
