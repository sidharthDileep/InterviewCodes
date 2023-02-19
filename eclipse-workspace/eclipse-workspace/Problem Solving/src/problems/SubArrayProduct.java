package problems;

public class SubArrayProduct {

	public static void main(String[] args) {

		// Given an array of positive numbers,
		// the task is to find the number of possible contiguous subarrays having
		// product less than a given number K

		int[] arr = { 1, 2, 3, 4 };
		int K = 10;
		int mul = 0;
		int n = arr.length;

		int count = 0;
		for (int i = 0; i < n; i++) {

			if (arr[i] < K)
				count++;

			mul = arr[i];
			for (int j = i + 1; j < n; j++) {

				mul = mul * arr[j];

				if (mul < K) {
					count++;
				} else {
					break;
				}
			}
		}

		System.out.println("Count :" + count);

	}

}
