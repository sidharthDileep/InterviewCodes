package stack;

public class Main {
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(4);
		s.push(5);
		s.push(9);
		s.push(2);
		
		s.peek();
		
		StackWithMax s1 = new StackWithMax();
		s1.push(20);
	    System.out.println(s1.getMax());
	    s1.push(10);
	    System.out.println(s1.getMax());
	    s1.push(50);
	    System.out.println(s1.getMax());
		
	}

}
