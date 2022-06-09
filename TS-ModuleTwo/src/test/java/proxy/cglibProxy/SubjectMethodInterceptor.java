package proxy.cglibProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/***
 * @Author trojan
 * @Date 2022/6/9 16:44
 * @Description 拦截器
 * @Version 1.0
 */
public class SubjectMethodInterceptor implements MethodInterceptor {


    /**
     * 拦截被代理类中的方法
     *
     * @param obj    被代理的对象（需要增强的对象）
     * @param method 被拦截的方法（需要增强的方法）
     * @param args   方法入参
     * @param proxy  用于调用原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("before method " + method.getName());
        Object object = proxy.invokeSuper(obj, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return object;

    }
}
