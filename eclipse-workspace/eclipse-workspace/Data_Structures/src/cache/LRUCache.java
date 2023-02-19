package cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

	private Deque<Integer> doublyQueue;

	private HashSet<Integer> hashSet;

	private final int CACHE_SIZE;

	LRUCache(int capacity) {
		doublyQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	public void refer(int page) {
		if (!hashSet.contains(page)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast();
				hashSet.remove(last);
			}
		} else {
			doublyQueue.remove(page);
		}
		doublyQueue.push(page);
		hashSet.add(page);
	}

	public void display() {
		Iterator<Integer> iterator = doublyQueue.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}

}
