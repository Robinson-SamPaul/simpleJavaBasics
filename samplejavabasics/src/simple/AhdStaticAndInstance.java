package simple;

public class AhdStaticAndInstance {

	public static void main(String[] args) {
		System.out.println(AavStaticAndFinal.class);
		
		Circle1 circle1 = new Circle1(5.0);
		double area = circle1.getArea();
		System.out.println(area);
		
		Circle2 circle2 = new Circle2(5.0);
		area = Circle2.getArea(circle2);
		System.out.println(area);
	}
}
class Circle1 {
    private double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    /*
     * Encapsulation: 
     * 		The getArea method directly accesses the radius instance variable. 
     * 		This encapsulates the behavior of computing the area within the Circle object.
     * Object-Oriented Design: 
     * 		The method getArea logically belongs to the Circle object 
     * 		because it operates on the data contained within the object. 
     * 		This aligns with OOP principles where methods that operate on 
     * 		instance data are defined as instance methods.
     * Intuitive Usage: 
     * 		Calling circle.getArea() is intuitive because it clearly indicates 
     * 		that you are asking the circle object for its area.
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
class Circle2 {
    private double radius;

    public Circle2(double radius) {
        this.radius = radius;
    }

	/*
	 * Utility Function Style: 
	 * 		The getArea method is defined as a static method and takes an instance of Circle as a parameter. 
	 * 		This style is more aligned with utility functions that operate on objects passed to them. 
	 * Not Encapsulated:
	 * 		The static method requires the Circle instance to be passed explicitly, 
	 * 		which breaks the encapsulation since the operation is not performed by the object itself. 
	 * Less Intuitive: 
	 * 		Calling Circle.getArea(circle) is less intuitive
	 * 		because it suggests a global operation rather than an operation specific to an instance of Circle.
	 */
    public static double getArea(Circle2 circle) {
        return Math.PI * circle.radius * circle.radius; 
        // radius is still inside class, so accessible even though it's private
    }
}
