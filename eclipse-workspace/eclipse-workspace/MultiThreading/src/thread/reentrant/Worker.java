package thread.reentrant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {

	ReentrantLock re;
	String name;

	public Worker(ReentrantLock r1, String n) {
		this.re = r1;
		this.name = n;
	}

	@Override
	public void run() {

		boolean done = false;

		while (!done) {
			boolean ans = re.tryLock();

			if (ans) {
				try {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println(
							"task name - " + name + " outer lock acquired at " + ft.format(d) + " Doing outer work");
					Thread.sleep(1500);
					re.lock();
					try {
						d = new Date();
						ft = new SimpleDateFormat("hh:mm:ss");
						System.out.println("task name - " + name + " inner lock acquired at " + ft.format(d)
								+ " Doing inner work");
						System.out.println("Lock Hold Count - " + re.getHoldCount());
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						// Inner lock release
						System.out.println("task name - " + name + " releasing inner lock");

						re.unlock();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					System.out.println("task name - " + name + " releasing outer lock");

					re.unlock();
					System.out.println("Lock Hold Count - " + re.getHoldCount());
				}
			}

		}

	}

}
