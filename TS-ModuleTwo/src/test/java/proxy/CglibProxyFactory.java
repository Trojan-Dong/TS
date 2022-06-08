package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class CglibProxyFactory {
    /**
     *
     * @param clazz
     * @return
     */
    public static Object getProxy(Class<?> clazz, MethodInterceptor methodInterceptor) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(methodInterceptor);
        // 创建代理类
        return enhancer.create();
    }
}
