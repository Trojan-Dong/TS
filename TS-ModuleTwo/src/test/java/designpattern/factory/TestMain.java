package designpattern.factory;

public class TestMain {
    public static void main(String[] args) {
        ShapeFactory factory=new ShapeFactory();
        Shape shape=factory.getShape("circle");
        shape.draw();
    }
}
