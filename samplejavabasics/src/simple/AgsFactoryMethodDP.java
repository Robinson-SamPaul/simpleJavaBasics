package simple;

public class AgsFactoryMethodDP {

	public static void main(String[] args) {
		
		Shape shape = new Circle(); // Tight coupling
		shape.draw();
		
		CommonShapeFactory shapeFactory = new CommonShapeFactory();
		Shape circleObj = shapeFactory.createCircle(); // will have all shape methods, if want new, need to modify 
		circleObj.draw();

		/* best practice for this DP */
		ShapeFactory circleFactory = new CircleFactory();
		Shape circle = circleFactory.createShape(); // each will have it's own method, if want new, need to add new class 
		circle.draw();
	}
}
/***********************************************************************************************************************/
interface Shape {
	void draw();
}
class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing Circle");
	}
}
class Hexagon implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}
class Triangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Drawing Triangle");
	}
}
/***********************************************************************************************************************/
class CommonShapeFactory {
	public Shape createCircle() {
		return new Circle();
	}
	public Shape createHexagon() {
		return new Hexagon();
	}
	public Shape createTriangle() {
		return new Triangle();
	}
}
/***********************************************************************************************************************/
interface ShapeFactory {
	Shape createShape();
}
class CircleFactory implements ShapeFactory {
	@Override
	public Shape createShape() {
		return new Circle();
	}
}
class HexagonFactory implements ShapeFactory {
	@Override
	public Shape createShape() {
		return new Hexagon();
	}
}
class TriangleFactory implements ShapeFactory {
	@Override
	public Shape createShape() {
		return new Triangle();
	}
}
