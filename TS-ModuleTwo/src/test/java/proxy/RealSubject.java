package proxy;

public class RealSubject implements Subject{
    @Override
    public void printOne() {
        System.out.println("this is one");
    }

    @Override
    public void printName(String name) {
        System.out.println("i am "+name);
    }
}
