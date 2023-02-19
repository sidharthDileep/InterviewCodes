package problems.interview;

import java.util.ArrayList;
import java.util.List;

public class TestInterview {

	public void test(Employee e) {

	}

	public void test2(EmployeeSuper e) {

	}

	public static void main(String[] args) {

		TestInterview test = new TestInterview();
		Employee e = new Employee();

		test.test(new Employee());

		EmployeeSuper es = new EmployeeSuper();

		// test.test((Employee) es);

		test.test2(e);

		// List<? extends MyType> list = new ArrayList<>();
		// "Remember PECS: Producer Extends, Consumer Super."
		// Since listOfMyType is a consumer (you are adding to it), super is valid and
		// extends is not

		List<Apple> apples = new ArrayList<Apple>();
		apples.add(new Apple());

		List<? extends Fruit> basket = apples;

		for (Fruit fruit : basket) {
			System.out.println(fruit);
		}

		// basket.add(new Apple()); //Compile time error
		// basket.add(new Fruit()); //Compile time error

		List<Apple> apples2 = new ArrayList<Apple>();
		apples2.add(new Apple());

		// We can assign a list of apples to a basket of apples
		List<? super Apple> basket2 = apples2;

		basket2.add(new Apple()); // Successful
		basket2.add(new AsianApple()); // Successful
		//basket2.add(new Fruit()); // Compile time error
		for (Object fruit : basket2) {
			System.out.println(fruit);
		}

	}

}

class EmployeeSuper {

}

class Employee extends EmployeeSuper {

}

class Fruit {
	@Override
	public String toString() {
		return "I am a Fruit !!";
	}
}

class Apple extends Fruit {
	@Override
	public String toString() {
		return "I am an Apple !!";
	}
}

class AsianApple extends Apple {
	@Override
	public String toString() {
		return "I am an AsianApple !!";
	}
}
