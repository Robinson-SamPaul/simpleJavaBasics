package accessSpecifier;

public class DifferentPackage {
	String show13(String str) {
		return "default different package " + str;
	}
	public String show14(String str) {
		return "public different package " + str;
	}
	protected String show15(String str) {
		return "protected different package " + str;
	}
//	private String show16(String str) {
//		return "private different package " + str;
//	}
	
}