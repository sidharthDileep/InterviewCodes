package problems.interview;

public class SmallestSubWithSum {

	public static void main(String[] args) {

		int arr1[] = { 1, 4, 45, 6, 10, 19 };
		int x = 51;
		int n1 = arr1.length;
		int res1 = smallestSubWithSum(arr1, n1, x);

		System.out.println(res1);

	}

	private static int smallestSubWithSum(int[] arr, int n, int x) {

		int curr_sum = 0, min_len = n + 1;

		int start = 0, end = 0;

		while (end < n) {

			while (curr_sum <= x && end < n) {
				curr_sum += arr[end++];
			}

			while (curr_sum > x && start < n) {

				if (end - start < min_len) {
					min_len = end - start;
				}

				curr_sum -= arr[start++];

			}

		}

		return min_len;
	}

}
