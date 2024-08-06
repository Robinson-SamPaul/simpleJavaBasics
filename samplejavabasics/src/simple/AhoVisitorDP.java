package simple;

import java.util.ArrayList;
import java.util.List;

public class AhoVisitorDP {
	public static void main(String[] args) {
		ShapeCollection shapes = new ShapeCollection();
		shapes.addShape(new Cirkle(5));
		shapes.addShape(new Rektangle(2, 3));

		System.out.println("Calculating area:");
		shapes.accept(new AreaVisitor());

		System.out.println("\nCalculating perimeter:");
		shapes.accept(new PerimeterVisitor());
	}
}
interface Visitor {
	void visit(Cirkle circle);

	void visit(Rektangle rectangle);
}
class AreaVisitor implements Visitor {
	@Override
	public void visit(Cirkle circle) {
		double area = Math.PI * circle.getRadius() * circle.getRadius();
		System.out.println("Cirkle area: " + area);
	}

	@Override
	public void visit(Rektangle rectangle) {
		double area = rectangle.getWidth() * rectangle.getHeight();
		System.out.println("Rektangle area: " + area);
	}
}
class PerimeterVisitor implements Visitor {
	@Override
	public void visit(Cirkle circle) {
		double perimeter = 2 * Math.PI * circle.getRadius();
		System.out.println("Cirkle perimeter: " + perimeter);
	}

	@Override
	public void visit(Rektangle rectangle) {
		double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
		System.out.println("Rektangle perimeter: " + perimeter);
	}
}
interface Shapes {
	void accept(Visitor visitor);
}
class Cirkle implements Shapes {
	private double radius;

	public Cirkle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

//Concrete Element for Rektangle
class Rektangle implements Shapes {
	private double width;
	private double height;

	public Rektangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

//Object Structure
class ShapeCollection {
	private List<Shapes> shapes = new ArrayList<>();

	public void addShape(Shapes shape) {
		shapes.add(shape);
	}

	public void accept(Visitor visitor) {
		for (Shapes shape : shapes) {
			shape.accept(visitor);
		}
	}
}
