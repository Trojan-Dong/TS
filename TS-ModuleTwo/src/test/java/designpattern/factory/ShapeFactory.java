package designpattern.factory;

import org.junit.platform.commons.util.StringUtils;

public class ShapeFactory {


    public Shape getShape(String shape) {
        if (StringUtils.isBlank(shape)) {
            return null;
        } else if ("Circle".equalsIgnoreCase(shape)) {
            return new Circle();
        } else if ("Rectangle".equalsIgnoreCase(shape)) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}
