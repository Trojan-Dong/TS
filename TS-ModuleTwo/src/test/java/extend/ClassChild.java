package extend;

public class ClassChild extends ClassParent {
    private int a;
    public String b;

    public ClassChild(int a, String b) {
        super(a, b); //除非指定调用父类的有参构造方法，否则会抛异常
    }
}
