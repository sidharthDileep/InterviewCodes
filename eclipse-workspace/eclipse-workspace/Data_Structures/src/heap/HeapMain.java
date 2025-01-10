package heap;

import java.util.Arrays;

import heap.Heap.HeapType;

public class HeapMain {
	
	public static void main(String[] args) {
        Heap minHeap = new Heap(HeapType.MIN_HEAP);
        minHeap.insert(5);
        System.out.println(Arrays.toString(minHeap.array));
        minHeap.insert(3);
        System.out.println(Arrays.toString(minHeap.array));
        minHeap.insert(8);
        System.out.println(Arrays.toString(minHeap.array));
        minHeap.insert(1);
        System.out.println(Arrays.toString(minHeap.array));

        System.out.println("Min Heap:");
        while (minHeap.size > 0) {
            System.out.print(minHeap.extract() + " ");
        }

        System.out.println();

        Heap maxHeap = new Heap(HeapType.MAX_HEAP);
        maxHeap.insert(5);
        System.out.println(Arrays.toString(maxHeap.array));
        maxHeap.insert(3);
        System.out.println(Arrays.toString(maxHeap.array));
        maxHeap.insert(8);
        System.out.println(Arrays.toString(maxHeap.array));
        maxHeap.insert(1);
        System.out.println(Arrays.toString(maxHeap.array));

        System.out.println("Max Heap:");
        while (maxHeap.size > 0) {
            System.out.print(maxHeap.extract() + " ");
        }
    }

}
