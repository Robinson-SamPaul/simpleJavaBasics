package simple;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AdbCusAnnotation {

	public static void main(String[] args) throws Exception {
		Class<?> clazz = Class.forName("simple.DummyForAnnotaion");
		
		DummyForAnnotaion annotaion = new DummyForAnnotaion(80000); // will work, it's not process, just meta info, below is the actual impl
		System.out.println(annotaion);
		
		AnnotationSample sampleClass = clazz.getDeclaredAnnotation(AnnotationSample.class);
		System.out.println(sampleClass);
		
		AnnotationSample sampleField = clazz.getDeclaredField("val").getDeclaredAnnotation(AnnotationSample.class);
		System.out.println(sampleField);
		
		AnnotationSample sampleMethod = clazz.getDeclaredMethod("getVal").getDeclaredAnnotation(AnnotationSample.class);
		System.out.println(sampleMethod);
		
		DummyForAnnotaion obj = new DummyForAnnotaion(10);
		test(annotaion);
		test(obj);
		test(new DummyForAnnotaion(700));
	}
	
	private static void test(DummyForAnnotaion obj) {

		if (obj.getClass().isAnnotationPresent(AnnotationSample.class)) {
			System.out.println("Annotation is having retentionPolicy as 'runtime', hence accessible");
			AnnotationSample annotaionObj = obj.getClass().getAnnotation(AnnotationSample.class);
			if(annotaionObj.maxValue() == 1000 && annotaionObj.minValue() == 100) {
				System.out.println("Properly used");
			} else {
				System.out.println("Not used properly");
			}
		} else {
			System.err.println("Annotation is not having retentionPolicy as 'runtime', hence not accessible");
		}
	}
}

/*
 * RetentionPolicy:
 * 
 * SOURCE: Only available during compilation. 
 * CLASS: Included in compiled byte code but not accessible at runtime. 
 * RUNTIME: Included in compiled byte code and accessible at runtime via reflection.
 */
//@Target(ElementType.FIELD) // for variables
//@Target(ElementType.METHOD) // for methods
//@Target(ElementType.TYPE) // can declare this to class, not using @Target means everywhere
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

/* Checking Annotation Values for Class DummyForAnnotation */
/*
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationSample {
    double maxValue();
    double minValue();
}

@AnnotationSample(maxValue = 100, minValue = 1000)
class DummyForAnnotation {
    // Class implementation
}

public class Main {
    public static void main(String[] args) {
        AnnotationSample annotation = DummyForAnnotation.class.getAnnotation(AnnotationSample.class);
        if (annotation != null) {
            double maxValue = annotation.maxValue();
            double minValue = annotation.minValue();
            System.out.println("Max Value: " + maxValue);
            System.out.println("Min Value: " + minValue);
        } else {
            System.out.println("Annotation not found");
        }
    }
}
*/

/* Checking Annotation Values for Field val */
/*
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationSample {
    double maxValue();
    double minValue();
}

class DummyForAnnotation {
    @AnnotationSample(maxValue = 100, minValue = 1000)
    private Integer val;
    
    public DummyForAnnotation(Integer val) {
        this.val = val;
    }

    // Getter and setter methods
    // ...

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = DummyForAnnotation.class.getDeclaredField("val");
        AnnotationSample annotation = field.getAnnotation(AnnotationSample.class);
        if (annotation != null) {
            double maxValue = annotation.maxValue();
            double minValue = annotation.minValue();
            System.out.println("Max Value for Field 'val': " + maxValue);
            System.out.println("Min Value for Field 'val': " + minValue);
        } else {
            System.out.println("Annotation not found for Field 'val'");
        }
    }
}
*/

/* Checking Annotation Values for Method getVal */
/*
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationSample {
    double maxValue();
    double minValue();
}

class DummyForAnnotation {
    private Integer val;
    
    public DummyForAnnotation(Integer val) {
        this.val = val;
    }

    @AnnotationSample(maxValue = 100, minValue = 1000)
    public Integer getVal() {
        return val;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = DummyForAnnotation.class.getDeclaredMethod("getVal");
        AnnotationSample annotation = method.getAnnotation(AnnotationSample.class);
        if (annotation != null) {
            double maxValue = annotation.maxValue();
            double minValue = annotation.minValue();
            System.out.println("Max Value for Method 'getVal': " + maxValue);
            System.out.println("Min Value for Method 'getVal': " + minValue);
        } else {
            System.out.println("Annotation not found for Method 'getVal'");
        }
    }
}
*/
