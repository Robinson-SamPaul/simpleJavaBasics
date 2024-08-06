package tricks;

public class StaticVsInstanceMethod {

	public static void main(String[] args) {

		ToyBox aliceToyBox = new ToyBox("Alice");
		System.out.println(aliceToyBox.instanceMethod());
		System.out.println(ToyBox.staticMethod(aliceToyBox));
	}
}

class ToyBox {
	private String childName;

	// Constructor to set the child's name when creating a toy box
	public ToyBox(String name) {
		this.childName = name;
	}

	// Instance method to get the child's name
	public String instanceMethod() {
		return this.childName;
	}

	// Static method to get the child's name
	public static String staticMethod(ToyBox obj) {
		return obj.childName;
	}
}
/*
	Method Area: 
		Part of the JVM heap, stores class metadata, and has a fixed size. 
		It'll store static variables and methods
		The size of the Method Area is determined by the number of classes loaded by the JVM 
		and the amount of metadata required to describe those classes.
	Metaspace: 
		Stored in native memory, dynamically manages class metadata, and provides flexibility in memory allocation
*/