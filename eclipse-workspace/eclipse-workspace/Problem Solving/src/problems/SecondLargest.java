package problems;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 5, 6, 3, 2 ,7};

		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		int n = arr.length;

		/*
		 * for (int i = 0; i < n; i++) { 
		 * if (arr[i] > max) { 
		 * max = arr[i]; 
		 * 	}
		 * }
		 * 
		 * for (int i = 0; i < n; i++) { 
		 * if (secMax < arr[i]) { 
		 * if (arr[i] != max) {
		 * secMax = arr[i]; 
		 * 	} 
		 * }
		 * 
		 * }
		 */

		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				secMax = max;
				max = arr[i];
			}
		}
		int[] numbers = { 5, 9, 11, 2, 8, 21, 1 };
		int secondLargestNumber = Arrays.stream(numbers).boxed()
										.sorted(Comparator.reverseOrder()).skip(1).findFirst()
										.get();

		System.out.println("Largest : " + max);
		System.out.println("Second Largest : " + secMax);
	}

}
