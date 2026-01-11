package simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddProxyMethod {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		ClassLoader classLoader = AddProxyMethod.class.getClassLoader();
		System.out.println("class loader = " + classLoader);
		System.out.println("class loader name = " + classLoader.getName());
		System.out.println("class loader class = " + classLoader.getClass());
		System.out.println();
		
		Class<?>[] clazz = new Class[] {Repo.class};
		System.out.println("Class = " + clazz);
		System.out.println("Class = " + Arrays.toString(clazz));
		System.out.println();
		
		InvokeHandler handler = new InvokeHandler(new RepoClass());
		System.out.println("Interface = " + handler);
		System.out.println();
		
		Repo repo = (Repo) Proxy.newProxyInstance(classLoader, clazz, handler);
		repo.show();
		repo.print("Hello World!");
		repo.toString();
//		repo.hashCode(); exception, due to hashcode return int primitive datatype and not object
		
		List<String> strings = new ArrayList<>();
		List list = (List) Proxy.newProxyInstance(classLoader, new Class[] {List.class}, new ListInvokeHandler(strings));

		list.add("Sam");
		System.out.println(strings);
		list.add("Rob");
		System.out.println(strings);
		list.remove("Sam");
		System.out.println(strings);
	}
}

interface Repo {
	
	void show();
	
	String print(String str);	
}

class RepoClass implements Repo {

	@Override
	public void show() {
		System.out.println("Hello from show");
	}

	@Override
	public String print(String str) {
		return "Hello from Print";
	}
	
}

class InvokeHandler implements InvocationHandler {
	
	private final Repo target;

    public InvokeHandler(Repo target) {
        this.target = target;
    }

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		/*
		 * In a Java dynamic proxy, every method invocation on the proxy instance,
		 * including interface methods and Object methods—is delegated to the InvocationHandler.invoke() method.
		 * 
		 * Every time when we call any method with Repo reference,
		 * invoke method will be called, not the actual method,
		 * then if we want we can invoke the original method and do whatever.
		 * 
		 * it is basically like beforeEach and afterEach
		 */
//		System.out.println(proxy); exception
		System.out.println("Method = " + method);
		System.out.println("Arguments = " + args);
		System.out.println("Before method call of " + method.getName());
		method.invoke(target, args);
		System.out.println("After method call of " + method.getName());
		System.out.println();
		return null;
	}	
}

class ListInvokeHandler implements InvocationHandler {
	
	private List<String> list;

	public ListInvokeHandler(List<String> list) {
		this.list = list;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// System.out.println(proxy); // exception
		System.out.println("Method = " + method);
		System.out.println("Arguments = " + args);
		System.out.println();
		return method.invoke(list, args);
	}	
}