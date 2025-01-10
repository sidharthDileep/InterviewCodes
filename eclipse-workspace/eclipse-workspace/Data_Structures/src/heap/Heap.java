package heap;

import java.util.Arrays;

public class Heap {
	int[] array;
	int size;
	private HeapType heapType;
	
	public enum HeapType {
		MIN_HEAP, MAX_HEAP
	}
	
	public Heap (HeapType heapType) {
		this.array = new int[10];
		int size = 0;
		this.heapType = heapType;
	}
	
	private int getParentIndex(int index){
		return (index - 1) / 2;
	}
	
	private int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}
	
	private int getRightChildIndex(int index) {
		return 2 * index + 2;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private int parent(int index) {
		return array[getParentIndex(index)];
	}
	
	private int leftChild(int index) {
		return array[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return array[getRightChildIndex(index)];
	}
	
	private void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private void ensureCapacity(){
		if(size == array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
	}
	
	public void insert(int value) {
		ensureCapacity();
		array[size] = value;
		size++;
		
		heapifyUp();
	}
	
	public int peek() {
		if(size == 0) {
			throw new IllegalStateException("Heap is Empty");
		}
		
		return array[0];
	}
	
	public int extract() {
		if(size == 0) {
			throw new IllegalStateException("Heap is Empty");
		}
		
		int root = array[0];
		array[0] = array[size - 1];
		size--;
		
		heapifyDown();
		
		return root;
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && compare(array[index], parent(index)) < 0) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && compare(rightChild(index), leftChild(index)) < 0) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(compare(array[index], array[smallerChildIndex]) < 0) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}
	
	private int compare(int a, int b) {
		return heapType == HeapType.MIN_HEAP ? Integer.compare(a, b) : Integer.compare(b, a);
	}
}
