package simple;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AdbCusAnnotation {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("simple.DummyForAnnotaion");
		
		AnnotationSample sampleClass = clazz.getDeclaredAnnotation(AnnotationSample.class);
		System.out.println(sampleClass);
		
		AnnotationSample sampleField = clazz.getDeclaredField("val").getDeclaredAnnotation(AnnotationSample.class);
		System.out.println(sampleField);
		
		AnnotationSample sampleMethod = clazz.getDeclaredMethod("getVal").getDeclaredAnnotation(AnnotationSample.class);
		System.out.println(sampleMethod);
	}

}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationSample {
	double maxValue();
	double minValue();
}

@AnnotationSample(maxValue = 100, minValue = 1000)
class DummyForAnnotaion {
	
	@AnnotationSample(maxValue = 100, minValue = 1000)
	private Integer val;
	
	public DummyForAnnotaion(Integer val) {
		this.val = val;
	}

	@AnnotationSample(maxValue = 100, minValue = 1000)
	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}
}
