package problems;

import java.util.Arrays;

public class ClosestNumbers {

	public static void main(String[] args) {

		int arr[] = { 6, 2, 4, 10 };
		int n = arr.length;
		printMinDiffPairs(arr, n);

	}

	private static void printMinDiffPairs(int[] arr, int n) {

		if (n <= 1)
			return;

		Arrays.sort(arr);

		int minDiff = arr[1] - arr[0];

		for (int i = 2; i < n; i++) {
			minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
		}

		for (int i = 1; i < n; i++) {
			if (minDiff == (arr[i] - arr[i - 1])) {
				System.out.println(arr[i - 1] + " " + arr[i]);
			}
		}
	}

}
