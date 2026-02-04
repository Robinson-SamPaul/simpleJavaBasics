package simple;

/*
 * Factory Method 	→ 	used to create one object
 * Abstract Factory → 	used to create a combination (family) of related objects
 */
public class AgtAbstractFactoryDP {
    public static void main(String[] args) {
        ShapeAbstractFactory factory = new CircleFactory2();
        Border border = factory.createBorder();
        Shape shape = factory.createShape();

        border.drawBorder();
        shape.draw();

        System.out.println();
        factory = new TriangleFactory2();
        border = factory.createBorder();
        shape = factory.createShape();

        border.drawBorder();
        shape.draw();
    }
}
/***********************************************************************************************************************/
interface Border {
    void drawBorder();
}
class CircleBorder implements Border {
    public void drawBorder() {
        System.out.println("Drawing Circle Border");
    }
}
class TriangleBorder implements Border {
    public void drawBorder() {
        System.out.println("Drawing Triangle Border");
    }
}
/***********************************************************************************************************************/
interface ShapeAbstractFactory {
    Shape createShape();
    Border createBorder();
}
class CircleFactory2 implements ShapeAbstractFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
    @Override
    public Border createBorder() {
        return new CircleBorder();
    }
}
class TriangleFactory2 implements ShapeAbstractFactory {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
    @Override
    public Border createBorder() {
        return new TriangleBorder();
    }
}