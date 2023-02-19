package thread.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class DemoCountDown {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(4);
		
		Worker2 first = new Worker2(1000, latch, "Worker-1");
		Worker2 second = new Worker2(1000, latch, "Worker-2");
		Worker2 third = new Worker2(1000, latch, "Worker-3");
		Worker2 four = new Worker2(1000, latch, "Worker-4");
		
		first.start();
		second.start();
		third.start();
		four.start();
		
		latch.await();
		
		System.out.println(Thread.currentThread().getName() +
                " has finished");
		
	}

}
