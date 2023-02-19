package problems.interview;

public class MultiThreadingTest {

	public static void main(String[] args) {

		MultiThreadingTest myClass = new MultiThreadingTest();
		myClass.call(new One());

		new MyThread().start();
		new MyThread(new MyRunnable()).start();

	}

	public void call(One one) {
		one.start();
	}

	static class One extends Thread {
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(i);
			}
		}
	}
}

class MyThread extends Thread {
	MyThread() {

	}

	MyThread(Runnable r) {
		super(r);
	}

	public void run() {
		System.out.println("Inside thread");
	}
}

class MyRunnable implements Runnable {

	public void run() {
		System.out.println("Inside runnable");
	}
}
