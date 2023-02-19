package thread.forkJoin;

import java.util.concurrent.ForkJoinPool;

public class forkjoinTest {

	public static void main(final String[] args) {

		int proc = Runtime.getRuntime().availableProcessors();

		System.out.println("Number of available core in the processor is: " + proc);

		ForkJoinPool Pool = ForkJoinPool.commonPool();

		System.out.println("Number of active thread before invoking: " + Pool.getActiveThreadCount());

		NewTask t = new NewTask(400);

		Pool.invoke(t);

		System.out.println("Number of active thread after invoking: " + Pool.getActiveThreadCount());
		System.out.println("Common Pool Size is: " + Pool.getPoolSize());

	}

}
