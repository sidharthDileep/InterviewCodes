package problems.application.washroom;

import java.util.Random;

public class Client implements Runnable {

	Washroom washroom;
	Random random = new Random();

	public Client(Washroom washroom) {
		this.washroom = washroom;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
