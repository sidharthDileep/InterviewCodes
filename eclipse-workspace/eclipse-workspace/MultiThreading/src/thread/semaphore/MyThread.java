package thread.semaphore;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

	Semaphore sem;
	String threadName;

	public MyThread(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	public void run() {

		if (this.getName().equals("A")) {
			System.out.println("Starting " + threadName);

			try {
				System.out.println(threadName + " is waiting for a permit.");

				sem.acquire();

				System.out.println(threadName + " gets a permit.");

				for (int i = 0; i < 5; i++) {
					Shared.count++;
					System.out.println(threadName + ": " + Shared.count);

					Thread.sleep(10);
				}

			} catch (InterruptedException exc) {
				System.out.println(exc);
			}

			System.out.println(threadName + " releases the permit.");
			sem.release();
		} else {

			System.out.println("Starting " + threadName);
			try {
				System.out.println(threadName + " is waiting for a permit.");

				sem.acquire();

				System.out.println(threadName + " gets a permit.");

				for (int i = 0; i < 5; i++) {
					Shared.count--;
					System.out.println(threadName + ": " + Shared.count);

					Thread.sleep(10);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}

			System.out.println(threadName + " releases the permit.");
			sem.release();

		}
	}

}
