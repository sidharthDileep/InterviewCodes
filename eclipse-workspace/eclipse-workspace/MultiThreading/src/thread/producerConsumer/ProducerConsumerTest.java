package thread.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerTest {

	public static void main(String[] args) {

		int numProducers = 4;
		int numConsumers = 3;

		BlockingQueue<Object> myQueue = new LinkedBlockingQueue<>(20);

		for (int i = 0; i < numProducers; i++) {
			new Thread(new Producer(myQueue)).start();
		}

		for (int i = 0; i < numConsumers; i++) {
			new Thread(new Consumer(myQueue)).start();
		}

		// Let the simulation run for, say, 10 seconds
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.exit(0);

	}

}
