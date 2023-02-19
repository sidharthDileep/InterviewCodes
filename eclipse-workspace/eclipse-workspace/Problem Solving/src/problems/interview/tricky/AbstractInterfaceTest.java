package problems.interview.tricky;

public class AbstractInterfaceTest {

	public static void main(String[] args) {

		
		TestClass test = new TestClass();
		
		test.testMethod();
		
		System.out.println();
	}

}

abstract class abstractTest {

}

interface interfaceTest {
	public static final int testVar = 0;
}

class TestClass implements interfaceTest {

	void testMethod() {
		System.out.println(testVar);
	}

}
