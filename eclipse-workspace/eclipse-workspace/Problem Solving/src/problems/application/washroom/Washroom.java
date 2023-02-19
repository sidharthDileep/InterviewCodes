package problems.application.washroom;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Washroom implements WashroomInterface {

	private Semaphore mutex = new Semaphore(1, true);

	private Lock lock = new ReentrantLock();
	private Condition womenWaitingQueue = lock.newCondition();
	private Condition menWaitingQueue = lock.newCondition();

	private int womenWaitingN = 0;
	private int menWaitingN = 0;
	private int womenUsingN = 0;
	private int menUsingN = 0;

	private int free_res = BATHROOM_SIZE;

	@Override
	public void manEnter() {
		lock.lock();
		menUsingN++;
		free_res--;
		if (free_res > 0 && womenUsingN == 0) {
			mutex.acquireUninterruptibly();
		} else {
			try {
				menWaitingQueue.await();
			} catch (Exception e) {
				System.out.println("E!");
			}
		}
		lock.unlock();
	}

	@Override
	public void manExit() {
		lock.lock();
		menUsingN--;
		free_res++;
		if (womenWaitingN > 0) {
			try {
				womenWaitingQueue.signal();
			} catch (Exception e) {
				System.out.println("E!");
			}
		}
		lock.unlock();
	}

	@Override
	public void womenEnter() {
		lock.lock();
		if (free_res > 0 && menUsingN == 0) {
			womenUsingN++;
			free_res--;
			mutex.acquireUninterruptibly();
		} else {
			try {
				womenWaitingQueue.await();
			} catch (Exception e) {
				System.out.println("E!");
			}
		}
		lock.unlock();
	}

	@Override
	public void womenExit() {
		lock.lock();
		womenUsingN--;
		free_res++;
		mutex.release();
		if (menWaitingN > 0) {
			try {
				menWaitingQueue.signal();
			} catch (Exception e) {
				System.out.println("E!");
			}
		}
		lock.unlock();
	}

}
