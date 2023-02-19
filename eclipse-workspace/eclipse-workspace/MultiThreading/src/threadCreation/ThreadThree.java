package threadCreation;

import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadThree implements Callable {

	public Object call() {
		Random generator = new Random();
		
		Integer random = generator.nextInt(5);
		
		System.out.println("Hello from Thread Three");
		
		return random;
	}

}
