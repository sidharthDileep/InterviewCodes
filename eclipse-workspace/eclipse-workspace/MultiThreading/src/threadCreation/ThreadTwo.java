package threadCreation;

public class ThreadTwo implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from Thread Two");
	}

}
