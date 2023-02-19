package thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {

		Semaphore sem = new Semaphore(1);
        
        MyThread mt1 = new MyThread(sem, "A");
        MyThread mt2 = new MyThread(sem, "B");
          
        mt1.start();
        mt2.start();
          
        mt1.join();
        mt2.join();
          
        System.out.println("count: " + Shared.count);

	}

}
