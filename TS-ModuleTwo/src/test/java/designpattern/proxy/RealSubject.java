package designpattern.proxy;

/**
 * 真实被代理的目标对象 必须得实现接口才能被代理
 */
public class RealSubject implements Subject {
    @Override
    public void printOne() {
        System.out.println("this is one");
    }

    @Override
    public void printName(String name) {
        System.out.println("i am " + name);
    }
}
