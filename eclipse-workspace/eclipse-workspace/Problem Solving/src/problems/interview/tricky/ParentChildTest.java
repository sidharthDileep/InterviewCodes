package problems.interview.tricky;

public class ParentChildTest {

	public static void main(String[] args) {

		Parent p = new Parent();
		System.out.println(p.a);

		System.out.println(p.methodtest());

		Child c = new Child();
		System.out.println(c.a);

		System.out.println(c.methodTest());

		Parent parent = new GrandChildren();

		parent.m1();
		// parent.m2();
		
		car car = new BMW();
		car.drive();
	}

}

class Parent {
	final static int a = 5;

	static int methodtest() {
		return 2;
	}

	public void m1() {

		System.out.println("Pm1");

	}
}

class Child extends Parent {
	static int a = 1;

	static int methodTest() {
		return 3;
	}

	public void m1() {

		System.out.println("Cm1");

	}

	public void m2() {

		System.out.println("Cm2");

	}
}

class GrandChildren extends Child {

	public void m2() {

		System.out.println("GCm2");

	}

}

class car {
	car(String name) {

		System.out.println("In Car class" + " " + name);

	}

	public static void drive() {

		System.out.println("driving cars");

	}
}

class BMW extends car {

	BMW() {
		this("BMW");
		System.out.println("In BMW default constructor");
	}

	BMW(String name) {
		super(name);
		System.out.println("In BMW parameterized constructor");
	}

	public static void drive() {
		System.out.println("Driving BMW");
	}
}
