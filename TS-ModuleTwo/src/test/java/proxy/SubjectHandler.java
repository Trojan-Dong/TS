package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
