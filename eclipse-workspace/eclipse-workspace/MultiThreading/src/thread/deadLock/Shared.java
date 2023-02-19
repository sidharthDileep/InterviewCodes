package thread.deadLock;

public class Shared {

	synchronized void test1(Shared s2) {

		System.out.println("Test 1 Begin");

		Util.sleep(1000);

		System.out.println("Test 1 End");

	}

	synchronized void test2(Shared s1) {

		System.out.println("Test 2 Begin");

		Util.sleep(1000);

		System.out.println("Test 2 End");

	}

}
