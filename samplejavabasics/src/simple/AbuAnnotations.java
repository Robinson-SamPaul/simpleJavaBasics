package simple;

public class AbuAnnotations {

	public static void main(String[] args) {
		
		@SuppressWarnings("removal") // similiar to deprecated
		Integer num = new Integer(8);
		FuncInterface fn = new FuncInterface() {
			
			@Override // method overrididng
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("Hello " + num);
			}
		};
		fn.show();
	}
}

@FunctionalInterface // contains only one method declaration, also known as Single Abstract Method
interface FuncInterface {
	
	void show();
}
