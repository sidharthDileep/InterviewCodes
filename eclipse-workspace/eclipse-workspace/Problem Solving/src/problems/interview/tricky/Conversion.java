package problems.interview.tricky;

public class Conversion {
	public void method(int i) {

		// Print statement
		System.out.println("Primitive type int formal argument :" + i);
	}

	// Method 2
	// Overloading method with reference formal argument
	public void method(Integer i) {

		// Print statement
		System.out.println("Reference type Integer formal argument :" + i);
	}

	// Method 2
	// Overloading method primitive formal argument
	// and to be invoked for wrapper Object as overloaded
	// method with wrapper object of same(Long) type as an
	// argument is not available.
	public void method(long i) {

		// Print statement
		System.out.println("Primitive type long formal argument :" + i);
	}

}
