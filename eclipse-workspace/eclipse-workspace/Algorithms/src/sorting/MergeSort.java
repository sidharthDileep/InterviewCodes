package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		// optimized approach
		int[] arr = { 1, 6, 8, 2, 4, 7, 9 };
		mergeSort(arr);

		// another approach
		//mergeSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

	}

	private static void mergeSort(int[] arr) {

		mergeSort(arr, new int[arr.length], 0, arr.length - 1);

	}

	private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd)
			return;

		int middle = (leftStart + rightEnd) / 2;
		mergeSort(arr, temp, leftStart, middle);
		mergeSort(arr, temp, middle + 1, rightEnd);

		mergeHalves(arr, temp, leftStart, rightEnd);

	}

	private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
		System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);

	}

	private static void mergeSort(int[] arr, int l, int r) {

		if (l >= r)
			return;

		int mid = l + (r - l) / 2;
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);
	}

	private static void merge(int[] arr, int l, int mid, int r) {

		int n1 = mid - l + 1;
		int n2 = r - mid;
		int X[] = new int[n1];
		int Y[] = new int[n2];

		for (int i = 0; i < n1; i++)
			X[i] = arr[l + i];

		for (int j = 0; j < n2; j++)
			Y[j] = arr[mid + 1 + j];

		int i = 0, j = 0, k = l;
		while (i < n1 && j < n2) {
			if (X[i] <= Y[j]) {
				arr[i] = X[i];
				i++;
			} else {
				arr[k] = Y[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = X[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = Y[j];
			j++;
			k++;
		}
	}
}
