package thread.ExecutorTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import threadCreation.Task;

public class DemoExecutor {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newSingleThreadExecutor();

		Future<String> result = executor.submit(new Task("Sidharth"));

		try {
			System.out.println(result.get());
		}

		catch (InterruptedException | ExecutionException e) {

			System.out.println("Error occurred while executing the submitted task");

			e.printStackTrace();
		}

		executor.shutdown();

		System.out.println("*******************************************************");

		ExecutorService executor2 = Executors.newFixedThreadPool(2);

		Runnable task = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				System.out.println("Current time :: " + LocalDateTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		executor2.execute(task);

		Future<?> result2 = executor2.submit(task, "DONE");

		while (result2.isDone() == false) {
			try {
				System.out.println("The method return value : " + result2.get());
				break;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		executor2.shutdown();

		System.out.println("*******************************************************");

		ExecutorService executor3 = Executors.newScheduledThreadPool(2);

		Runnable task1 = () -> {
			System.out.println("Executing the task1 at: " + new Date());
		};

		Runnable task2 = () -> {
			System.out.println("Executing the task2 at: " + new Date());
		};

		System.out.println("Scheduling task to run after 5 seconds... " + new Date());
		((ScheduledExecutorService) executor3).schedule(task1, 5, TimeUnit.SECONDS);
		((ScheduledExecutorService) executor3).schedule(task2, 5, TimeUnit.SECONDS);

		executor3.shutdown();
		//System.out.println("Thread main finished");

		System.out.println("*******************************************************");

		ThreadPoolExecutor executor4 = (ThreadPoolExecutor) Executors.newCachedThreadPool();

		System.out.println("Largest executions: " + executor4.getLargestPoolSize());
		System.out.println("Maximum allowed threads: " + executor4.getMaximumPoolSize());
		System.out.println("Current threads in pool: " + executor4.getPoolSize());
		System.out.println("Currently executing threads: " + executor4.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + executor4.getTaskCount());
		
		System.out.println("&&&&&");
		executor4.submit(new thread.ExecutorTest.Task());
		executor4.submit(new thread.ExecutorTest.Task());

		System.out.println("Core threads: " + executor4.getCorePoolSize());
		System.out.println("Largest executions: " + executor4.getLargestPoolSize());
		System.out.println("Maximum allowed threads: " + executor4.getMaximumPoolSize());
		System.out.println("Current threads in pool: " + executor4.getPoolSize());
		System.out.println("Currently executing threads: " + executor4.getActiveCount());
		System.out.println("Total number of threads(ever scheduled): " + executor4.getTaskCount());

		System.out.println("*******************************************************");
		
	}

}
