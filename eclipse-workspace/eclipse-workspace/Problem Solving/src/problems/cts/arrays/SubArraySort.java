package problems.cts.arrays;

import java.util.Arrays;

public class SubArraySort {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11 };

		System.out.println(Arrays.toString(subArraySort(arr)));
	}

	private static int[] subArraySort(int[] arr) {
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];

			if (outOfOrder(arr, i)) {
				smallest = Math.min(smallest, x);
				largest = Math.max(largest, x);
			}
		}

		if (smallest == Integer.MAX_VALUE)
			return new int[] { -1, -1 };

		int left = 0;
		while (smallest >= arr[left])
			left++;

		int right = arr.length - 1;
		while (largest <= arr[right])
			right--;

		return new int[] { left, right };

	}

	private static boolean outOfOrder(int[] arr, int i) {

		int x = arr[i];

		if (i == 0)
			return x > arr[i];

		if (i == arr.length - 1)
			return x < arr[i];

		return x > arr[i + 1] || x < arr[i - 1];
	}

}
