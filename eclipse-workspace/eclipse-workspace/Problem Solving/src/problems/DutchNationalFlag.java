package problems;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

		threeWayPartition(arr);

		System.out.println(Arrays.toString(arr));

	}

	private static void threeWayPartition(int[] A) {
		int start = 0, mid = 0;
		int pivot = 1;
		int end = A.length - 1;

		while (mid <= end) {

			if (A[mid] < pivot) {
				swap(A, start, mid);
				System.out.println(Arrays.toString(A));
				++start;
				++mid;
			} else if (A[mid] > pivot) {
				swap(A, mid, end);
				System.out.println(Arrays.toString(A));
				--end;
			} else {
				++mid;
			}

		}

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
