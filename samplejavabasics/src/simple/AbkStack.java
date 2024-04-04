package simple;

import java.util.Stack;

public class AbkStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> val = new Stack<>();
		val.push(6);
		val.push(7);
		val.push(67);
		val.pop();
		for(int i : val) {
			System.out.println(i);
		}
	}

}
