package problems.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TestInterview3 {

	public static void main(String[] args) {

		List<String> stringList = new ArrayList<String>();

		stringList.add("ONE");
		stringList.add("TWO");
		stringList.add("THREE");

		Stream<String> stream = stringList.stream();

		Test test = () -> System.out.println("Hi");

		test.testMethod();

		int item = 0;
		
		LinkedList<Integer> lists = new LinkedList<>();

	}

}

class Parent {
	static int a;
}

class Child extends Parent {

}

interface Base {
	// int num;
	public static final int num = 0;
}

class Derived implements Base {

}

@FunctionalInterface
interface Test {
	void testMethod();
}

interface Test2 extends Test {

}

abstract class Abstract implements Test {
	void foo() {
		System.out.println("Foo");
	}

	abstract void abstractFoo();
}

class AbstractTest extends Abstract{

	@Override
	public void testMethod() {
		super.foo();
	}

	@Override
	void abstractFoo() {
		
	}
	
}