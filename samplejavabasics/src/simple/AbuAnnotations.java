package simple;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AbuAnnotations {

	/*
	 * An annotation is metadata that provides information to the compiler or tools about the code — 
	 * but doesn’t directly affect execution.
	 */
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
		
		Class<AnnotatedClass> obj = AnnotatedClass.class;

        if (obj.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation ann = obj.getAnnotation(MyAnnotation.class);
            System.out.println(ann.value()); // Output: Hello
            System.out.println(ann.count()); // Output: 5
        }
	}
}

@FunctionalInterface // contains only one method declaration, also known as Single Abstract Method
interface FuncInterface {
	
	void show();
}

@Target(ElementType.TYPE)       // Where it can be used (class, method, field, etc.)
@Retention(RetentionPolicy.RUNTIME)  // When it is available (compile time or runtime)
@interface MyAnnotation {
    String value();             // Required element
    int count() default 1;      // Optional element with default
}

@MyAnnotation(value = "Hello", count = 5)
class AnnotatedClass {
    // class content
}
