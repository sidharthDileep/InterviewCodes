package problems.interview.tricky;

import java.util.HashMap;
import java.util.Map;

public class TrickyQuestions2 {

	public static void main(String[] args) {
		/*Design a class such that only one instance of the class and any of its sub-classes can be created.
		To clarify: Assume A is such a class and B and C are derived from A. 
		B, C does not have any special code apart from extending A
		new A(); // works fine.
		new A(); // causes an exception
		new B(); // works fine as this is the first instance of B
		new B(); // causes an exception.
		new C(); // works fine as this is the first instance of C
		new C(); // causes an exception.*/

		A a = new A();
		

	}

}

class A1 {

    private static Map<Class<? extends A>, A> instances = new HashMap<>();

    public A1() {
        synchronized (A1.class) {
            if (instances.containsKey(this.getClass())) {
                throw new IllegalStateException();
            }
            //instances.put(getClass(), this);
        }
    }
    
    // code of class A
}

class B1 extends A1 {

}
