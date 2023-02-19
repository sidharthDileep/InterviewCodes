package problems.interview.tricky;

public class TrickyQuestions {

	public static int counter = 5;

	public static void main(String args[]) {

		TrickyQuestions obj = new TrickyQuestions();

		System.out.println(obj.counter);
		obj.counter++;
		System.out.println(obj.counter);

		A a = new B();
		a.methodTest(null);
		a.methodTest(5);
		a.methodTest("String");
		a.methodTest(a);

		int value = exceptionTest();

		System.out.println("Value : " + value);

		// searchApi, JPA, washroomQues
		// parellel stream
		
		A a1 = new A();
		B b1 = new B();
		
		a1.method();
		b1.method();
		
		A a2 = new B();
		//B b2 = new A();
		
		a2.method();
		

	}

	public static int exceptionTest() {
		try {
			// System.exit(0);
			// throw new Exception();
			return 1;
		} catch (Exception e) {
			return 3;
		} finally {
			return 2;
		}

	}

}

class A {

	public void methodTest(String a) {
		System.out.println("String");
	}

	public void methodTest(Object a) {
		System.out.println("Object");
	}
	
	/*
	 * public void methodTest(Integer a) { 
	 * System.out.println("Object"); 
	 * }
	 */

	public void method() {
		System.out.println("Class A");
	}
}

class B extends A {

	public void method() {
		System.out.println("Class B");
	}

}