package simple;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class AeyGarbageCollection {
	
	public static void main(String[] args) {
		
		/* 
		 * When garbage collector runs and finds out 
		 * that no object references this, it'll be deleted
		 */		
		Object object1 = new Object();
		
		/* 
		 * When garbage collector runs, it'll be deleted
		 */
		WeakReference<Object> object2 = new WeakReference<Object>(new Object());
		
		/* 
		 * When garbage collector runs and finds out 
		 * that there's no sufficient space, it'll be deleted
		 */
		SoftReference<Object> object3 = new SoftReference<Object>(new Object());
		
		System.out.println(object1 + "\n" + object2 + "\n" + object3);
		
		for (double i = 0; i < 10000.0; i++) {
            new String(String.valueOf(i));
        }
		System.out.println("Loop ends");

        /*
         * It's important to note that calling System.gc() or 
         * Runtime.getRuntime().gc() is just a suggestion to the JVM, 
         * and the actual execution of garbage collection is determined by the 
         * JVM's garbage collection algorithms and policies
         */
		System.gc();
	}
	
	/*
	 * Can't be private, as JVM can't access
	 * Not good practice to declare public
	 * 
	 * When GC is invoked, finalize method is called
	 */
	protected void finalize() {
		System.out.println("Hi fro GC");
	}

}
