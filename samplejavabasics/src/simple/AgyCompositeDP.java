package simple;

import java.util.ArrayList;
import java.util.List;

public class AgyCompositeDP {
	public static void main(String[] args) {
		SemiCircle circle = new SemiCircle();
		Square square = new Square();

		CompositeGraphic composite = new CompositeGraphic();
		composite.addGraphic(circle);
		composite.addGraphic(square);

		// Create another composite shape
		CompositeGraphic anotherComposite = new CompositeGraphic();
		anotherComposite.addGraphic(circle);
		anotherComposite.addGraphic(square);
		anotherComposite.addGraphic(composite); // Composite within a composite

		// Draw the composite shapes
		composite.draw();
		System.out.println("----");
		anotherComposite.draw();
	}
}

interface Graphic {
	void draw();
}
class SemiCircle implements Graphic {
	@Override
	public void draw() {
		System.out.println("Drawing a Circle");
	}
}
class Square implements Graphic {
	@Override
	public void draw() {
		System.out.println("Drawing a Square");
	}
}
class CompositeGraphic implements Graphic {
	private List<Graphic> graphics = new ArrayList<>();

	public void addGraphic(Graphic graphic) {
		graphics.add(graphic);
	}

	public void removeGraphic(Graphic graphic) {
		graphics.remove(graphic);
	}

	@Override
	public void draw() {
		System.out.println("Drawing a Composite Shape:");
		for (Graphic graphic : graphics) {
			graphic.draw(); // Delegate drawing to individual shapes
		}
	}
}
