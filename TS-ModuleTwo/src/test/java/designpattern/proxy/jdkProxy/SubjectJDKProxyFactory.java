package designpattern.proxy.jdkProxy;

import java.lang.reflect.Proxy;

/***
 * @Author trojan
 * @Date 2022/6/9 16:44
 * @Description 获取代理对象工厂类
 * @Version 1.0
 */
public class SubjectJDKProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载器
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new SubjectHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}
