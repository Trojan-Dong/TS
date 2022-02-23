package designpattern.singleton;

public class TestMain {
    public static void main(String[] args) {
        SingletonHungry.getInstance();
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
    }
}
