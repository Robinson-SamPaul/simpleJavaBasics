package simple;

public class AgnOpenClosed {

	public static void main(String[] args) {
		String openForExtension = ""
				+ "You should be able to extend the behavior of a module without modifying its source code. "
				+ "This can be achieved by adding new functionality through inheritance, composition, or other means without changing the existing code.";
		String closedForModification = ""
				+ "Once a class or module has been implemented and tested, you should not change its source code. "
				+ "This ensures that the existing functionality remains unchanged and stable, reducing the risk of introducing new bugs.";
		System.out.println(openForExtension + "\n" + closedForModification);
	}
}
/**************************************************************************************************************************/
// Suppose you have a class that calculates the area of different shapes
/*
 * This class violates the OCP because if you want to add support for a new shape, 
 * such as a circle, you would have to modify the AreaCalculator class
 */
class AreaCalculator1 {
    public double calculateArea(Rectangle1 rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }
}

class Rectangle1 {
    private double width;
    private double height;

    public Rectangle1(double width, double height) {
        this.width = width;
        this.height = height;
    }

	public double getHeight() {
		return this.height;
	}
	public double getWidth() {
		return this.width;
	}
}
/**************************************************************************************************************************/
class AreaCalculator2 {
    public double calculateArea(Shape1 shape) {
        return shape.getArea();
    }
}
interface Shape1 {
    double getArea();
}
// if you need to add a new shape, you can simply implement the Shape interface 
// without modifying the AreaCalculator class:
class Rectangle implements Shape1 {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}