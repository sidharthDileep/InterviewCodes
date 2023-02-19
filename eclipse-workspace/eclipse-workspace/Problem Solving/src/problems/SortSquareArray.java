package problems;

import java.util.Arrays;

public class SortSquareArray {

	public static void main(String[] args) {
		int arr[] = { -6, -3, -1, 2, 4, 5 };
		int n = arr.length;

		System.out.println("Before sort ");
		System.out.print(Arrays.toString(arr));

		sortSquares(arr);

		System.out.println("");

		System.out.println("After Sort ");
		System.out.print(Arrays.toString(arr));

	}

	private static void sortSquares(int[] arr) {

		int left = 0;
		int n = arr.length;
		int right = n - 1;

		int result[] = new int[n];

		for (int index = right; index >= 0; index--) {
			if (Math.abs(arr[left]) > Math.abs(arr[right])) {
				result[index] = arr[left] * arr[left];
				left++;
			} else {
				result[index] = arr[right] * arr[right];
				right--;
			}
		}

		for (int i = 0; i < n; i++) {
			arr[i] = result[i];
		}

	}

}
