package threadPool;

public class ThreadPoolTest {

	public static void main(String[] args) {
		
		CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(10);
		threadPoolExecutor.addTask(() -> System.out.println("First Task"));
		threadPoolExecutor.addTask(() -> System.out.println("Second Task"));
	}

}
