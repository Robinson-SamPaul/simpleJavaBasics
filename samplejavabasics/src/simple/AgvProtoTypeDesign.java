package simple;

public class AgvProtoTypeDesign {
	public static void main(String[] args) {
		System.out.println(AatCloneAndFinalize.class);
		
		// Create an original Sphere
        Sphere originalSphere = new Sphere(10, "red");
        System.out.println("Original Sphere: " + originalSphere);

        // Clone the original Sphere
        Sphere clonedSphere = originalSphere.clone();
        System.out.println("Cloned Sphere: " + clonedSphere);

        // Modify the cloned Sphere
        clonedSphere.setRadius(20);
        clonedSphere.setColor("blue");
        System.out.println("Modified Cloned Sphere: " + clonedSphere);

        // Original Sphere remains unchanged
        System.out.println("Original Sphere after modification: " + originalSphere);
	}
}
interface Prototype extends Cloneable { // interface extends interface
    Prototype clone();
}
class Sphere implements Prototype {
    private int radius;
    private String color;

    public Sphere(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Sphere clone() {
        try {
            return (Sphere) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Sphere [radius=" + radius + ", color=" + color + "]";
    }
}
