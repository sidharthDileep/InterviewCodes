package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {

	private final BlockingQueue<Runnable> workerQueue;
	private final Thread[] workerThreads;

	CustomThreadPoolExecutor(int numThreads) {
		workerQueue = new LinkedBlockingQueue<>();
		workerThreads = new Thread[numThreads];
		int i = 0;
		for (Thread t : workerThreads) {
			t = new Worker("Custom Pool Thread" + ++i);
			t.start();
		}
	}

	public void addTask(Runnable r) {
		try {
			workerQueue.put(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	class Worker extends Thread {

		Worker(String name) {
			super(name);
		}

		public void run() {
			while (true) {
				try {
					workerQueue.take().run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

}
