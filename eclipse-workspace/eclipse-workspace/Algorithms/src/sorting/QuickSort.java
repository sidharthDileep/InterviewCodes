package sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		System.out.println(Arrays.toString(arr));

		quickSort(arr, 0, n - 1);

		// quickSort2(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		System.out.println(Arrays.toString(arr));

	}

	private static void quickSort(int[] arr, int left, int right) {

		if (left >= right)
			return;

		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);

	}

	private static int partition(int[] arr, int left, int right, int pivot) {

		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}

		}
		return left;
	}
	
	
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////

	private static void quickSort2(int[] arr, int low, int high) {

		if (low < high) {

			int pi = partition2(arr, low, high);
			quickSort2(arr, low, pi - 1);
			quickSort2(arr, pi + 1, high);

		}
	}

	private static int partition2(int[] arr, int low, int high) {

		int pivot = arr[high];

		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		System.out.println(Arrays.toString(arr));
		swap(arr, i + 1, high);
		System.out.println(Arrays.toString(arr));
		return (i + 1);
	}


}
