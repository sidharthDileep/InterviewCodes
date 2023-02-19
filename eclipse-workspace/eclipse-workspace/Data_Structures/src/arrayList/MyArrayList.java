package arrayList;

import java.util.Arrays;

public class MyArrayList {

	private Object[] myStore;
	private int actSize = 0;

	public MyArrayList() {
		myStore = new Object[10];
	}

	public Object get(int index) {
		if (index < actSize) {
			return myStore[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void add(Object obj) {
		if (myStore.length - actSize <= 5) {
			increaseListSize();
		}
		myStore[actSize++] = obj;
	}

	private void increaseListSize() {
		myStore = Arrays.copyOf(myStore, myStore.length * 2);
		System.out.println("\nNew length: " + myStore.length);
	}

	public Object remove(int index) {
		if (index < actSize) {
			Object obj = myStore[index];
			myStore[index] = null;
			int tmp = index;
			while (tmp < index) {
				myStore[tmp] = myStore[tmp + 1];
				myStore[tmp + 1] = null;
				tmp++;
			}
			actSize--;
			return index;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public int size() {
		return actSize;
	}

}
