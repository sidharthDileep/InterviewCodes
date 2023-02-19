package problems;

import java.util.Arrays;

public class MissingPositive {
	public static void main(String[] args) {
		int arr[] = { 0, 10, 2, -10, -20 };
		int arr_size = arr.length;

		// array containing -ve's also
		int missing = findMissing(arr, arr_size);
		System.out.println("The smallest positive missing number is " + missing);

		int arr2[] = { 2, 3, -7, 6, 8, 1, -10, 15 };
		int n = arr2.length;
		int ans = firstMissingPositiveV2(arr2, n);

		System.out.println();

		System.out.println("First Missing  " + ans);

		int ans2 = firstMissingPositiveV3(arr2);

		System.out.println();

		System.out.println("First Missing : " + ans2);

		// array containing +ve's only
		int[] arr3 = { 1, 2, 3, 5 };
		int N = arr.length;
		System.out.println(getMissingNo(arr3, N-1));
	}

	private static int getMissingNo(int[] nums, int n) {
		int sum = ((n + 1) * (n + 2)) / 2;
		for (int i = 0; i < n; i++) {
			sum -= nums[i];
		}
		return sum;
	}

	private static int findMissing(int[] arr, int n) {

		int shift = segregate(arr, n);
		int arr2[] = new int[n - shift];
		System.out.println();
		int j = 0;
		for (int i = shift; i < n; i++) {
			arr2[j] = arr[i];
			j++;
		}

		return findMissingPositive(arr2, j);
	}

	private static int findMissingPositive(int[] arr, int n) {

		for (int i = 0; i < n; i++) {
			int x = Math.abs(arr[i]);
			if (x - 1 < n && arr[x - 1] > 0) {
				arr[x - 1] = -arr[x - 1];
			}
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				return i + 1;
			}
		}

		return (n + 1);
	}

	private static int segregate(int[] arr, int n) {
		int j = 0, i;

		for (i = 0; i < n; i++) {
			if (arr[i] <= 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}

		return j;
	}

	static int firstMissingPositiveV2(int arr[], int n) {
		Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
		System.out.println();
		for (int i = 0; i < n; i++) {

			while (arr[i] >= 1 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {

				int temp = arr[arr[i] - 1];
				arr[arr[i] - 1] = arr[i];
				arr[i] = temp;

				Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
				System.out.println();

			}
		}

		Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

		System.out.println();

		for (int i = 0; i < n; i++) {
			if (arr[i] != i + 1)
				return (i + 1);
		}

		return (n + 1);
	}

	public static int firstMissingPositiveV3(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 1;
		}

		int n = nums.length, containsOne = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] == 1) {
				containsOne = 1;
			} else if (nums[i] < 1 || nums[i] > n) {
				nums[i] = 1;
			}
		}

		if (containsOne == 0)
			return 1;

		for (int i = 0; i < n; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -1 * nums[index];
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return n + 1;
	}

}
