package stack;

import java.util.Stack;

public class StackWithMax {
	
	static Stack<Integer> mainStack = new Stack();
	
	static Stack<Integer> trackStack = new Stack();
	
	
	public void push(int x) {
		
		mainStack.push(x);
		if(mainStack.size() == 1) {
			trackStack.push(x);
			return;
			
		}
		
		if(x > trackStack.peek()) {
			trackStack.push(x);
		} else {
			trackStack.push(trackStack.peek());
		}
		
	}
	
	static int getMax() {
			return trackStack.peek();
	}
	
	static void pop() {
		mainStack.pop();
		trackStack.pop();
	}
	
}
