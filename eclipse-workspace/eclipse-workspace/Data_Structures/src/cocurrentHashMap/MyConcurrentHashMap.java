package cocurrentHashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMap {

	public MyConcurrentHashMap(int initialCapacity, float loadFactor) {

		int cap = getCapacity();

	}

	private int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	final Segment[] segments = new Segment[32];
	private int threshold;
	private int loadFactor;

	protected Entry[] newTable(int capacity) {
		this.threshold = ((int) (capacity * this.loadFactor / 32.0F) + 1);
		return new Entry[capacity];
	}

	
	
	

	class Entry implements Map.Entry {
		protected final Object key;
		protected volatile Object value;
		protected final int hash;
		protected final Entry next;

		Entry(int hash, Object key, Object value, Entry next) {

			this.value = value;
			this.hash = hash;
			this.key = key;
			this.next = next;
		}

		@Override
		public Object getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getValue() {
			// TODO Auto-generated method stub
			return null;
		}
		
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

		@Override
		public Object setValue(Object value) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
	
	//int hashVal = hash(key);

	static int hash(Object x) {
		int h = x.hashCode();
		return (h << 7) - h + (h >>> 9) + (h >>> 17);
	}

	final class Segment {

		protected int count;

		protected synchronized int getCount() {
			return this.count;
		}

	}
	
	//Segment seg = segments[(hashVal & 0x1F)];
	
	/*
	 * synchronized (seg) { // code to add
	 * 
	 * int index = hashVal & table.length - 1; // hash we have calculated for key
	 * and table is Entry[] table Entry first = table[index]; for (Entry e = first;
	 * e != null; e = e.next) { if ((e.hash == hashVal) && (eq(key, e.key))) { // if
	 * key already exist means updating the value Object oldValue = e.value; e.value
	 * = value; return oldValue; } }
	 * 
	 * Entry newEntry = new Entry(hashVal, key, value, first); // new entry, i.e.
	 * this key not exist in map table[index] = newEntry; // Putting the Entry
	 * object at calculated Index }
	 */

}
