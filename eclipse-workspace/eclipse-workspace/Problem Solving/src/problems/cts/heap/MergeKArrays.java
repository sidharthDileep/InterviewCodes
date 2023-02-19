package problems.cts.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKArrays {

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
		int[] result = mergeSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println("The final merged sorted array is :- " + Arrays.toString(result));

		ArrayList<Integer> result2 = mergeKArrays(new int[][] { arr1, arr2, arr3 }, 3);

		System.out.println(result2);

	}

	private static int[] mergeSortedArray(int[][] arr) {

		PriorityQueue<ArrayBucket> queue = new PriorityQueue<>();
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayBucket(arr[i], 0));
			total = total + arr[i].length;
		}
		System.out.println(queue.toString());
		int m = 0;
		int[] result = new int[total];
		while (!queue.isEmpty()) {
			ArrayBucket ac = queue.poll();
			System.out.println(queue.toString() + "First");
			result[m++] = ac.arr[ac.index];
			if (ac.index < ac.arr.length - 1) {
				queue.add(new ArrayBucket(ac.arr, ac.index + 1));
			}
			System.out.println(queue.toString() + "Second");
			System.out.println(Arrays.toString(result));
		}

		return result;
	}

	public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		PriorityQueue<HeapNode> heap = new PriorityQueue<HeapNode>();

		// Initially add only first column of elements. First
		// element of every array
		for (int i = 0; i < arr.length; i++) {
			heap.add(new HeapNode(i, 0, arr[i][0]));
		}

		HeapNode curr = null;
		while (!heap.isEmpty()) {
			curr = heap.poll();
			result.add(curr.value);

			// Check if next element of curr min exists,
			// then add that to heap.
			if (curr.element_index < (arr[curr.arr_index].length - 1)) {
				heap.add(new HeapNode(curr.arr_index, curr.element_index + 1,
						arr[curr.arr_index][curr.element_index + 1]));
			}
		}

		return result;
	}

	public ListNode mergeKLists(ListNode[] lists) {

		Comparator<ListNode> cmp;
		cmp = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		};
		Queue<ListNode> queue = new PriorityQueue<>(cmp);

		for (ListNode l : lists) {
			if (l != null) {
				queue.add(l);
			}
		}

		ListNode head = new ListNode(0);
		ListNode point = head;

		while (!queue.isEmpty()) {
			point.next = queue.poll();
			point = point.next;

			ListNode next = point.next;
			if (next != null) {
				queue.add(next);
			}
		}
		return head.next;
	}

}

class ArrayBucket implements Comparable<ArrayBucket> {

	int[] arr;
	int index;

	public ArrayBucket(int[] arr, int index) {
		this.arr = arr;
		this.index = index;
	}

	@Override
	public int compareTo(ArrayBucket o) {
		return this.arr[this.index] - o.arr[o.index];
	}

	@Override
	public String toString() {
		return "ArrayBucket [arr=" + Arrays.toString(arr) + ", index=" + index + "]";
	}

}

class HeapNode implements Comparable<HeapNode> {
	int arr_index;
	int element_index;
	int value;

	HeapNode(int x, int y, int value) {
		this.arr_index = x;
		this.element_index = y;
		this.value = value;
	}

	@Override
	public int compareTo(HeapNode hn) {
		if (this.value <= hn.value) {
			return -1;
		} else {
			return 1;
		}
	}
}