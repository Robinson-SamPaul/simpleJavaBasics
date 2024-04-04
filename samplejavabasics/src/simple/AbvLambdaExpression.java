package simple;

public class AbvLambdaExpression {

	public static void main(String[] args) {
		
		FuncInterface fn = () -> System.out.println("Hello"); // if one line, return & curly don't need
		
//		FuncInterface fn = new FuncInterface() {
//			
//			@Override
//			public void show() {
//				// TODO Auto-generated method stub
//				System.out.println("Hello");
//			}
//		};
		
		fn.show();
	}
}
