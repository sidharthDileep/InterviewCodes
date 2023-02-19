package threadCreation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class DemoThreadCreation {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		ThreadOne tOne = new ThreadOne();
		tOne.start();
		
		Thread tTwo = new Thread(new ThreadTwo());
		tTwo.start();
		
		FutureTask task = new FutureTask(new ThreadThree());
		Thread tThree = new Thread(task);
		tThree.start();
		
		System.out.println(task.get());
		
	}

}
