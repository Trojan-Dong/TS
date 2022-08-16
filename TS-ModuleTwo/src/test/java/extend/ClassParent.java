package extend;

public class ClassParent {

    private int a;

    private String b;

    public ClassParent() { // 声明有参构造方法时，必须显式声明无参构造方法，否则子类继承时必须要调用父类对应的有参构造方法(super(args))

    }

    public ClassParent(int a, String b) {
        this.a = a;
        this.b = b;
    }


    public static void swap(String a, String b) {
        a = b;
        b.replace("456", a);
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }
}
