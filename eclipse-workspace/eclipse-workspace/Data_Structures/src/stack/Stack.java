package stack;

public class Stack {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	
	Stack(){
		top = -1;
	}
	
	boolean push(int x) {
		if(top >= (MAX - 1)) {
			System.out.println("Stack overflow");
			return false;
		}else {
			a[++top] = x;
			System.out.println(x + " pushed in to stack");
			return true;
		}
	}
	
	int pop() {
		if(top < 0) {
			System.out.println("Stack underflow");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}
	
	int peek() {
		if(top < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x = a[top];
			return x;
		}
	}
	
	boolean isEmpty() {
		return (top < 0);
	}

}
