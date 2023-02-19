package problems.interview.tricky;

public class SubTypeTest {
	public static void main(String args[]) {

		Base x = new Base();
		Base y = new Derived();
		Derived z = new Derived();

		DoPrint(x);
		DoPrint(y);
		DoPrint(z);

	}

	static void DoPrint(Base o) {
		o.Print();
	}
}

class Vehicle {

}

class Bike extends Vehicle {

}

class Base {
	public void Print() {
		System.out.println("Base");
	}
}

class Derived extends Base {
	public void Print() {
		System.out.println("Derived");
	}
}